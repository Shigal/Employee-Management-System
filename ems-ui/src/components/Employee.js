import React from "react";
import { useNavigate } from "react-router-dom";

const Employee = ({ employee, deleteEmployee }) => {
  const navigate = useNavigate();

  const editEmployee = (e, id) => {
    e.preventDefault();
    navigate(`/editEmployee/${id}`);
  };

  return (
    <tr key={employee.id}>
      <td className="text-left px-6 py-3 whitespace-nowrap">
        <div className="text-sm text-teal-700">{employee.firstName}</div>
      </td>
      <td className="text-left px-6 py-3 whitespace-nowrap">
        <div className="text-sm text-teal-700">{employee.lastName}</div>
      </td>
      <td className="text-left px-6 py-3 whitespace-nowrap">
        <div className="text-sm text-teal-700">{employee.emailId}</div>
      </td>
      <td className="text-right px-6 py-3 whitespace-nowrap font-medium text-sm">
        <a
          onClick={(e, id) => editEmployee(e, employee.id)}
          className="text-emerald-600 hover:text-emerald-800 hover:cursor-pointer px-4"
        >
          Edit
        </a>
        <a
          className="text-rose-600 hover:text-rose-800 hover:cursor-pointer"
          onClick={(e, id) => deleteEmployee(e, employee.id)}
        >
          Delete
        </a>
      </td>
    </tr>
  );
};

export default Employee;
