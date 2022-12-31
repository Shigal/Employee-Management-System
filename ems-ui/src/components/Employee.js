import React from "react";

const Employee = ({ employee }) => {
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
        <a href="#" className="text-emerald-600 hover:text-emerald-800 px-4">
          Edit
        </a>
        <a href="#" className="text-rose-600 hover:text-rose-800 ">
          Delete
        </a>
      </td>
    </tr>
  );
};

export default Employee;
