<%@ page import="com.model.Employee" %>
<html>
<body>

<h2>Display Employee</h2>

<form action="DisplayEmployeeServlet" method="post">
Emp No: <input type="text" name="empno">
<input type="submit" value="Search">
</form>

<hr>

<%
Employee emp = (Employee) request.getAttribute("employee");
String error = (String) request.getAttribute("error");

if (error != null) {
%>
<p style="color:red;"><%= error %></p>
<%
}

if (emp != null) {
%>
<p>Emp No: <%= emp.getEmpno() %></p>
<p>Name: <%= emp.getEmpName() %></p>
<p>DoJ: <%= emp.getDoj() %></p>
<p>Gender: <%= emp.getGender() %></p>
<p>Salary: <%= emp.getBsalary() %></p>
<%
}
%>

</body>
</html>