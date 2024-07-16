import Header from "./components/Header";

import "bootstrap/dist/css/bootstrap.css";
import Footer from "./components/Footer";
import Home from "./components/Home";
import { Outlet, Route, Routes } from "react-router-dom";
import Routing from "./components/Routing";
import AddVehicle from "./components/AddVehicle";

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/addvehicle" element={<AddVehicle />}></Route>
      </Routes>
      <Footer />
    </>
  );
}

export default App;
