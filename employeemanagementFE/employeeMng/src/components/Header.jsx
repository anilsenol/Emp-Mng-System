import React from "react";
import "../styles/Header.css";
import { Link } from "react-router";

export const Header = () => {
  return (
    <div className="company-name">
      <h2>Company's Name</h2>

      <div className="navigations">
        <Link className="links" to="/">
          Home Page
        </Link>
        <Link className="links" to="/all-employees">
          All Employees
        </Link>
        <Link className="links" to="/save-employee">
          Save Employee
        </Link>
        <Link className="links" to="/delete-employee">
          Delete Employee
        </Link>
      </div>
    </div>
  );
};
