import React, { useState, useEffect } from "react";
import "../styles/EmployeePage.css";
import axios from "axios";

export const AllEmployees = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/rest/api/employee/getAll")
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error("Error fetching employees:", error);
      });
  }, []);

  return (
    <div className="employee-page">
      <table className="employee-table">
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Date of Birth</th>
            <th>Salary (USD)</th>
          </tr>
        </thead>
        <tbody>
          {employees.length > 0 ? (
            employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{employee.phoneNumber}</td>
                <td>{new Date(employee.dateOfBirth).toLocaleDateString()}</td>
                <td>{employee.salary.toLocaleString()}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="6" className="no-employees-message">
                No employees found
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};
