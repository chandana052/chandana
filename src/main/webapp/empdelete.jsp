<html>
<head>
<title>Delete Employee</title>

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

input {
    width: 90%;
    padding: 8px;
    margin: 10px;
}

input[type=submit] {
    background: #e74c3c;
    color: white;
    border: none;
}

input[type=submit]:hover {
    background: #c0392b;
}
</style>

<script>
function validate() {
    let id = document.f.empno.value;

    if (id == "" || isNaN(id)) {
        alert("Enter valid Employee ID");
        return false;
    }
    return true;
}
</script>

</head>

<body>

<h2>Delete Employee</h2>

<!-- 🔹 Show Messages -->
<%
String error = (String) request.getAttribute("error");
String success = (String) request.getAttribute("success");

if (error != null) {
%>
<p style="color:red;"><%= error %></p>
<%
}

if (success != null) {
%>
<p style="color:green;"><%= success %></p>
<%
}
%>

<!-- 🔹 Form -->
<form name="f" action="DeleteEmployeeServlet" method="post" onsubmit="return validate()">

Employee ID:
<input type="text" name="empno" placeholder="Enter Employee ID">

<input type="submit" value="Delete Employee">

</form>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>