import React, { useState, useEffect } from "react";
import axios from "axios";
import "../styles/SaveEmployeePage.css";

export const SaveEmployeePage = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [salary, setSalary] = useState("");
  const [departments, setDepartments] = useState([]);
  const [jobPositions, setJobPositions] = useState([]);
  const [selectedDepartment, setSelectedDepartment] = useState("");
  const [selectedJobPosition, setSelectedJobPosition] = useState("");

  useEffect(() => {
    axios
      .get("http://localhost:8080/rest/api/department/getAll")
      .then((response) => setDepartments(response.data))
      .catch((error) => console.error("Error fetching departments:", error));

    axios
      .get("http://localhost:8080/rest/api/jobposition/getAll")
      .then((response) => setJobPositions(response.data))
      .catch((error) => console.error("Error fetching job positions:", error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    const newEmployee = {
      firstName,
      lastName,
      email,
      phoneNumber,
      dateOfBirth,
      salary,
      department: { id: selectedDepartment },
      jobPosition: { id: selectedJobPosition },
    };

    axios
      .post("http://localhost:8080/rest/api/employee/save", newEmployee)
      .then((response) => {
        alert("Employee saved successfully!");
        console.log(response.data);
        // Formu sıfırlamak için
        setFirstName("");
        setLastName("");
        setEmail("");
        setPhoneNumber("");
        setDateOfBirth("");
        setSalary("");
        setSelectedDepartment("");
        setSelectedJobPosition("");
      })
      .catch((error) => {
        console.error("Error saving employee:", error);
        alert("Failed to save employee.");
      });
  };

  return (
    <div className="save-employee-page">
      <h1>Add New Employee</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>First Name</label>
          <input
            type="text"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Last Name</label>
          <input
            type="text"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Phone Number</label>
          <input
            type="text"
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Date of Birth</label>
          <input
            type="date"
            value={dateOfBirth}
            onChange={(e) => setDateOfBirth(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Salary</label>
          <input
            type="number"
            value={salary}
            onChange={(e) => setSalary(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Department</label>
          <select
            value={selectedDepartment}
            onChange={(e) => setSelectedDepartment(e.target.value)}
            required
          >
            <option value="" disabled>
              Select Department
            </option>
            {departments.map((department) => (
              <option key={department.id} value={department.id}>
                {department.department}
              </option>
            ))}
          </select>
        </div>
        <div className="form-group">
          <label>Job Position</label>
          <select
            value={selectedJobPosition}
            onChange={(e) => setSelectedJobPosition(e.target.value)}
            required
          >
            <option value="" disabled>
              Select Job Position
            </option>
            {jobPositions.map((jobPosition) => (
              <option key={jobPosition.id} value={jobPosition.id}>
                {jobPosition.title}
              </option>
            ))}
          </select>
        </div>
        <button type="submit">Save Employee</button>
      </form>
    </div>
  );
};
