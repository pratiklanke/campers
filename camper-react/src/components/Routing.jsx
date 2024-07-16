import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./Home";
import AddVehicle from "./AddVehicle";

const Routing = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/addvehicle" element={<AddVehicle />}></Route>
      </Routes>
    </>
  );
};

export default Routing;
