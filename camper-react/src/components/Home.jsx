import React, { useEffect, useState } from "react";
import VehicleCard from "./VehicleCard";
import axios from "axios";

const Home = (vehicles) => {
  const [allVehi, setAllVehi] = useState([]);

  function getAllVehicles() {
    axios.get("http://localhost:8080/all/vehicles").then((response) => {
      console.log(response.data);
      setAllVehi(response.data);
    });
  }

  useEffect(() => {
    getAllVehicles();
  }, []);
  return (
    <div>
      <div>
        {allVehi.map((vehicle) => (
          <VehicleCard key={vehicle.vehicleId} vehicle={vehicle} />
        ))}
      </div>
    </div>
  );
};

export default Home;
