# Employee-Management-System

## Front-end: Tailwind CSS

- to install Tailwind CSS to the app

```

npm install -D tailwindcss
npx tailwindcss init

```
- get tailwind.config.js file

- use axios framework - to call API
    - to hit the backend api to fetch the data
    * install axios
    `` npm install axios``
- to handle data 
    * when save button is clicked, save the data into react state
    - using useState() we save the state of the form (data from form) and when it gets submitted data is passed to the API
    
- set initial state of employee, with its set method

````

const AddEmployee = () => {
const [employee, setEmployee] = useState({
id: "",
firstName: "",
lastName: "",
emailId: "",
});

````
- value is obtained as

``` 
<input
    name="firstName"
    value={employee.firstName}
    onChange={(e) => handleChange(e)}
    type="text"
    className="h-10 w-95 border mt-2 px-2 py-2"
    ></input>
```
- on change, we set the employee with whatever value we get from the target and set it to the existing fields(firstName, lastName, emailId)
- onchange: whenever there is a change in the input field that change will be updated in the state as well
- here, e.target is this given input and e.target.[any field]

````
const handleChange = (e) => {
    const value = e.target.value;
    setEmployee({...employee, [e.target.name]: value});
}

````

- now change is updated into the state
- On the click of save button, whatever state we stored we need to pass it to the REST API

- to prevent the refresh of page on click: `` e.preventDefault();``
```aidl
const saveEmployee = (e) => {
    e.preventDefault();
    EmployeeService.saveEmployee(employee).then((response) => {
        console.log(response);
    }).catch((error) => {
        console.log(error);
    })
  }
  
```

- to call the API using axios - define a method saveEmployee()

```
class EmployeeService {

    saveEmployee(employee) {
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }

}

```

- User React-routers to handle/navigate to multiple pages 
- install react-router in our project

`` npm i react-router-dom ``

- ``<BrowserRouter>`` handles entire routing 

```aidl
function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<EmployeeList/>}></Route>
          <Route index element={<EmployeeList/>}></Route>
          <Route path="/employeeList" element={<EmployeeList/>}></Route>
          <Route path="/addEmployee" element={<AddEmployee/>}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}
```

- when render starts call the data and display it on the table: useEffect hook
- we need to have 2 states: to fetch all data, to handle loading of data
  
````
  const [loading, setLoading] = useState(true);
  const [employees, setEmployees] = useState(null);
````
- useEffect hook to fetch the data

````
useEffect(() => {
   const fetchData = async () => {
    setLoading(true);
    try{
      const response = await EmployeeService.getEmployees();
      setEmployees(response.data);
    } catch(error) {
      console.log(error);
    } 
    setLoading(false);
   };
   fetchData();
  }, [])
````
- here, we use ``async`` with ``wait`` to wait till the data gets loaded
- while data is loading we set it to true
- in try block we get all the employees by calling the API
- then we set the state for employees with whatever data we get from the response
- when fetching of data is done we again get loading to false
- once the data is loaded we display the data

- delete action

```aidl
const deleteEmployee = (e, id) => {
    e.preventDefault();
    EmployeeService.deleteEmployee(id).then((res => {
      if(employees) {
        setEmployees((prevElement) => {
          return prevElement.filter((employee) => employee.id != id)
        })
      }
    }))
  }
```
- here, we prevent refreshing of the page. Then we call the method delete() by passing the id.
- when we get the response, we set the new state for the employee, from previous state for each employee we are filtering out the employee with the given id
- here, we first delete employee from the database then we delete the same employee from the stored state

- ``(!loading && <>)``, this means if not loading then render whatever given in <>
- to deconstruct the value from parameter
``const {id} = useParams();``
  
-  



#

## Back-end: Spring Boot

- Employee is a model class and EmployeeEntity is an entity for repo purpose
- to copy all the data from one object to other

```

@Override
public Employee createEmployee(Employee employee) {
    EmployeeEntity employeeEntity = new EmployeeEntity();
    BeanUtils.copyProperties(employee, employeeEntity);
    employeeRepository.save(employeeEntity);
    return employee;
}

```

