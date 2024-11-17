
import './App.css'
import{useTable} from 'react-table'
import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Add from './component/Add';
function App() {
  const[employee, setEmployee]=useState([]);
  const columns = React.useMemo(() => [
    { Header: "Id", accessor: "id" },
    { Header: "Name", accessor: "name" },
    { Header: "Manager", accessor: "manager" },
    { Header: "Salary", accessor: "salary" }
     ], []);
     const data=React.useMemo(()=>employee,[employee]);
     const {
      getTableProps,
      getTableBodyProps,
      headerGroups,
      rows,prepareRow
    }=useTable({columns,data});

     const getAllEmployees=()=>{
       axios.get("http://localhost:8080/employees").then((res)=>{
        console.log(res.data);
        setEmployee(res.data)

       })
     }

     useEffect(()=>{
      getAllEmployees();
     },[])
  return (
    <>
    <div className=''>     
      
       <div className='border-2 bg-purple-300 justify-center items-center w-fit m-2 p-2 '>
      <h2 className='font-medium text-rose-600 text-2xl'>Full stack Apllication using react , java spring boot and postgresql </h2>
    <Add atuorefress={getAllEmployees}/>
      </div>
      </div>

      {/* //Tables  propertics  */}
      <table {...getTableProps()} className="table-auto border-collapse border border-gray-300 m-4">
        <thead className="bg-pink-300">
          {headerGroups.map((headerGroup) => (
            <tr {...headerGroup.getHeaderGroupProps()} key={headerGroup.id}>
              {headerGroup.headers.map((column) => (
                <th {...column.getHeaderProps()} key={column.id} className="border border-gray-400 p-2">
                  {column.render("Header")}
                </th>
              ))}
            </tr>
          ))}
        </thead>
        <tbody className='bg-yellow-100' {...getTableBodyProps()}>
          {rows.length === 0 ? (
            <tr>
              <td colSpan={columns.length} className="text-center p-2">
                No data available
              </td>
            </tr>
          ) : (
            rows.map((row) => {
              prepareRow(row);
              return (
                <tr {...row.getRowProps()} key={row.id}>
                  {row.cells.map((cell) => (
                    <td {...cell.getCellProps()} key={cell.column.id} className="border border-gray-400 p-2">
                      {cell.render("Cell")}
                    </td>
                  ))}
                </tr>
              );
            })
          )}
        </tbody>
      </table>


    </>
  )
}

export default App
