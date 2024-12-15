import React from "react";
import "../src/App.css";
import { AllEmployees } from "./components/AllEmployeesPage";
import { Route, Routes } from "react-router-dom";
import { Header } from "./components/Header";
import { SaveEmployeePage } from "./components/SaveEmployeePage";
import { DeleteEmployeePage } from "./components/DeleteEmployeePage";
import { HomePage } from "./components/HomePage";

function App() {
  return (
    <div>
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/all-employees" element={<AllEmployees />} />
        <Route path="/save-employee" element={<SaveEmployeePage />} />
        <Route path="/delete-employee" element={<DeleteEmployeePage />} />
      </Routes>
    </div>
  );
}

export default App;
