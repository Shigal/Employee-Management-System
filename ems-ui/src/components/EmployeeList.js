import React from "react";
import { useNavigate } from "react-router-dom";

const EmployeeList = () => {
  const navigate = useNavigate();

  return (
    <div className="container mx-auto my-8">
      <div className="h-12 my-5">
        <button
          className="rounded bg-teal-700 text-white px-2 py-2 font-semibold"
          onClick={() => navigate("/addEmployee")}
        >
          Add Employee
        </button>
      </div>
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-teal-50">
            <tr>
              <th className="text-left font-medium text-teal-800 uppercase tracking-wider px-5 py-3">
                First Name
              </th>
              <th className="text-left font-medium text-teal-800 uppercase tracking-wider px-5 py-3">
                Last Name
              </th>
              <th className="text-left font-medium text-teal-800 uppercase tracking-wider px-5 py-3">
                Email
              </th>
              <th className="text-right font-medium text-teal-800 uppercase tracking-wider px-5 py-3">
                Actions
              </th>
            </tr>
          </thead>
          <tbody className="bg-gray-50">
            <tr>
              <td className="text-left px-6 py-3 whitespace-nowrap">
                <div className="text-sm text-teal-700">Kendall</div>
              </td>
              <td className="text-left px-6 py-3 whitespace-nowrap">
                <div className="text-sm text-teal-700">Kendall</div>
              </td>
              <td className="text-left px-6 py-3 whitespace-nowrap">
                <div className="text-sm text-teal-700">Kendall</div>
              </td>
              <td className="text-right px-6 py-3 whitespace-nowrap font-medium text-sm">
                <a
                  href="#"
                  className="text-emerald-600 hover:text-emerald-800 px-4"
                >
                  Edit
                </a>
                <a href="#" className="text-rose-600 hover:text-rose-800 ">
                  Delete
                </a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default EmployeeList;
