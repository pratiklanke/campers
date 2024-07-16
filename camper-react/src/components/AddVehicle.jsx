import React, { useState } from "react";
import "../css/index.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const AddVehicle = () => {
  const [image, setImage] = useState();

  const [company, setCompany] = useState();

  const [modelName, setModelName] = useState();

  const [registrationNumber, setRegistratioNumber] = useState();

  const [rent, setRent] = useState();

  const [deposit, setDeposite] = useState();

  const [description, setDescription] = useState();

  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/owner/vehicle/add", {
        file: image,
        company: company,
        modelName: modelName,
        deposite: deposit,
        registrationNumber: registrationNumber,
        description: description,
        rent: rent,
      })
      .then(() => {
        navigate("/");
      });
  };

  return (
    <form className="vehicle-form" onSubmit={handleSubmit}>
      <label htmlFor="vehiclePhoto">Vehicle Photo:</label>
      <br />
      <input
        type="file"
        id="vehiclePhoto"
        name="vehiclePhoto"
        accept="image/*"
        onChange={(e) => setImage(e.target.value)}
        required
      />
      <br />
      <br />

      <label htmlFor="company">Company:</label>
      <br />
      <input
        type="text"
        id="company"
        name="company"
        placeholder="Enter Company Name"
        onChange={(e) => setCompany(e.target.value)}
        required
      />
      <br />
      <br />

      <label htmlFor="modelName">Model Name:</label>
      <br />
      <input
        type="text"
        id="modelName"
        name="modelName"
        onChange={(e) => setModelName(e.target.value)}
        required
      />
      <br />
      <br />

      <label htmlFor="registrationNumber">Registration Number:</label>
      <br />
      <input
        type="text"
        id="registrationNumber"
        name="registrationNumber"
        onChange={(e) => setRegistratioNumber(e.target.value)}
        required
      />
      <br />
      <br />

      <label htmlFor="rent">Rent:</label>
      <br />
      <input
        type="number"
        id="rent"
        name="rent"
        onChange={(e) => setRent(e.target.value)}
        step="0.01"
        required
      />
      <br />
      <br />

      <label htmlFor="deposit">Deposit:</label>
      <br />
      <input
        type="number"
        id="deposit"
        name="deposit"
        onChange={(e) => setDeposite(e.target.value)}
        step="0.01"
        required
      />
      <br />
      <br />

      <label htmlFor="description">Description:</label>
      <br />
      <textarea
        id="description"
        name="description"
        onChange={(e) => setDescription(e.target.value)}
        rows="4"
        cols="50"
        required
      ></textarea>
      <br />
      <br />

      <input type="submit" value="Submit" />
    </form>
  );
};

export default AddVehicle;
