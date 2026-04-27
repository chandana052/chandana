<html>
<head>
<script>
function validate() {
    let id = document.f.empno.value;
    let sal = document.f.bsalary.value;

    if (id == "" || isNaN(id)) {
        alert("Enter valid ID");
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
<h2>Update Employee</h2>

<form name="f" action="UpdateEmployeeServlet" method="post" onsubmit="return validate()">
Emp No: <input type="text" name="empno"><br>
Name: <input type="text" name="empName"><br>
DoJ: <input type="date" name="doj"><br>
Gender:
<select name="gender">
<option>Male</option>
<option>Female</option>
</select><br>
Salary: <input type="text" name="bsalary"><br><br>

<input type="submit" value="Update">
</form>

</body>
</html>