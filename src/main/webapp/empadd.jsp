<html>
<head>
<title>Add Employee</title>

<style>
body {
    font-family: Arial;
    background: #f2f2f2;
    text-align: center;
}

form {
    background: white;
    padding: 20px;
    margin: auto;
    width: 300px;
    border-radius: 10px;
    box-shadow: 0 0 10px gray;
}

input, select {
    width: 90%;
    padding: 8px;
    margin: 8px;
}

input[type=submit] {
    background: #4CAF50;
    color: white;
    border: none;
}

input[type=submit]:hover {
    background: #45a049;
}
</style>

<script>
function validate() {
    let id = document.f.empno.value;
    let name = document.f.empName.value;
    let doj = document.f.doj.value;
    let sal = document.f.bsalary.value;

    if (id == "" || isNaN(id)) {
        alert("Enter valid Employee ID");
        return false;
    }

    if (name == "") {
        alert("Enter Employee Name");
        return false;
    }

    if (doj == "") {
        alert("Select Date of Joining");
        return false;
    }

    if (sal == "" || isNaN(sal) || sal < 0) {
        alert("Enter valid salary");
        return false;
    }

    return true;
}
</script>

</head>

<body>

<h2>Add Employee</h2>

<form name="f" action="AddEmployeeServlet" method="post" onsubmit="return validate()">

Emp No:
<input type="text" name="empno">

Name:
<input type="text" name="empName">

Date of Joining:
<input type="date" name="doj">

Gender:
<select name="gender">
    <option value="">Select</option>
    <option>Male</option>
    <option>Female</option>
</select>

Salary:
<input type="text" name="bsalary">

<input type="submit" value="Add Employee">

</form>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>