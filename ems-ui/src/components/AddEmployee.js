import React, { useState } from "react";
import EmployeeService from "../services/EmployeeService";

const AddEmployee = () => {
  const [employee, setEmployee] = useState({
    id: "",
    firstName: "",
    lastName: "",
    emailId: "",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setEmployee({ ...employee, [e.target.name]: value });
  };

  const saveEmployee = (e) => {
    e.preventDefault();
    EmployeeService.saveEmployee(employee)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="flex max-w-2xl shadow border-b mx-auto">
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Add New Employee</h1>
        </div>
        <div className="items-center justify-center h-15 w-full my-4">
          <label className="block text-gray-700 font-normal text-sm">
            First Name
          </label>
          <input
            name="firstName"
            value={employee.firstName}
            onChange={(e) => handleChange(e)}
            type="text"
            className="h-10 w-95 border mt-2 px-2 py-2"
          ></input>
        </div>
        <div className="items-center justify-center h-15 w-full my-4">
          <label className="block text-gray-700 font-normal text-sm">
            Last Name
          </label>
          <input
            name="lastName"
            value={employee.lastName}
            onChange={(e) => handleChange(e)}
            type="text"
            className="h-10 w-95 border mt-2 px-2 py-2"
          ></input>
        </div>
        <div className="items-center justify-center h-15 w-full my-4">
          <label className="block text-gray-700 font-normal text-sm">
            Email
          </label>
          <input
            name="emailId"
            value={employee.emailId}
            onChange={(e) => handleChange(e)}
            type="email"
            className="h-10 w-95 border mt-2 px-2 py-2"
          ></input>
        </div>
        <div className="items-center justify-center h-15 w-full my-4 space-x-4 pt-4">
          <button
            onClick={saveEmployee}
            className=" rounded bg-green-600 font-semibold text-white py-2 px-4 hover:bg-green-700"
          >
            Save
          </button>
          <button className=" rounded bg-red-600 font-semibold text-white py-2 px-4 hover:bg-red-700">
            Clear
          </button>
        </div>
      </div>
    </div>
  );
};

export default AddEmployee;
