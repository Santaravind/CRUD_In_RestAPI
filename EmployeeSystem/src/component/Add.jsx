import React, { useRef } from 'react'
import axios from 'axios'
function Add({atuorefress}) {
      const nameRef=useRef(null);
      const managerRef=useRef(null);
      const salaryRef=useRef(null);

       const handlsubmit=async (event)=>{
        event.preventDefault(); // Prevent the default form submission behavior

        // Access values from the refs
        const formData = {
          name: nameRef.current.value,
          manager: managerRef.current.value,
          salary: salaryRef.current.value,
        };

        await axios.post("http://localhost:8080/employees",formData).then((ref)=>{
            console.log("Form Data:", formData);
            atuorefress();
        })
    
       
    
        // Optionally, reset the form
        nameRef.current.value = "";
        managerRef.current.value = "";
        salaryRef.current.value = "";
       }
  return (
    <div>
        <form onSubmit={handlsubmit} action="">
        <div  className='m-3 p-2 flex gap-4'  >
   
        <label htmlFor="" className='ml-2 text-2xl' >Name</label> <br />
        <input type="text" ref={nameRef} className='border-4 rounded-lg border-red-500 hover:border-pink-800' />
        </div>
        <div>
        <label htmlFor="" className='ml-2 text-2xl'> Manager</label><br />
        <input type="text" ref={managerRef} className='border-4 rounded-lg border-red-500 hover:border-pink-800' />
        </div>
        <div>
        <label htmlFor="" className='ml-2 text-2xl'>Salary</label><br /> 
        <input type="text"  ref={salaryRef} className='border-4 rounded-lg border-red-500 hover:border-pink-800' />
        </div>
        <button type='submit' className='ml-2 text-2xl border-4 rounded-lg p-1 bg-green-400'>Add</button>
        <button className='ml-2 text-2xl border-4 rounded-lg p-1 bg-green-500'>Cancel</button>
        
     </form>
    </div>
  )
}

export default Add
