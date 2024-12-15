import React, { useState, useEffect } from "react";
import axios from "axios";
import "../styles/EmployeePage.css";

export const DeleteEmployeePage = () => {
  const [employees, setEmployees] = useState([]);
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const fetchEmployees = () => {
    axios
      .get("http://localhost:8080/rest/api/employee/getAll")
      .then((response) => {
        setEmployees(response.data);
        setErrorMessage("");
      })
      .catch((error) => {
        console.error("Error fetching employees:", error);
        setErrorMessage("Failed to fetch employees. Please try again later.");
      });
  };

  useEffect(() => {
    fetchEmployees();
  }, []);

  const handleDelete = (id, firstName, lastName) => {
    const confirmDelete = window.confirm(
      `Are you sure you want to delete ${firstName} ${lastName}?`
    );

    if (!confirmDelete) {
      return;
    }

    axios
      .delete("http://localhost:8080/rest/api/employee/delete", {
        params: { employeeId: id },
      })
      .then(() => {
        setSuccessMessage(
          `Employee ${firstName} ${lastName} deleted successfully.`
        );
        setErrorMessage("");
        fetchEmployees();
      })
      .catch((error) => {
        console.error("Error deleting employee:", error);
        setSuccessMessage("");
        setErrorMessage("Failed to delete employee.");
      });
  };

  return (
    <div className="employee-page">
      <h1>Delete Employee</h1>
      {successMessage && (
        <div className="success-message">{successMessage}</div>
      )}
      {errorMessage && <div className="error-message">{errorMessage}</div>}
      <table className="employee-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.length > 0 ? (
            employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>
                  <button
                    className="delete-button"
                    onClick={() =>
                      handleDelete(
                        employee.id,
                        employee.firstName,
                        employee.lastName
                      )
                    }
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="no-employees-message">
                No employees found.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};
