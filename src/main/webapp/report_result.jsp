<%@ page import="java.util.*, com.model.Employee" %>
<html>
<body>

<h2>Report Result</h2>

<%
List<Employee> list = (List<Employee>) request.getAttribute("reportList");

if (list != null && !list.isEmpty()) {
%>

<table border="1">
<tr>
<th>EmpNo</th>
<th>Name</th>
<th>DoJ</th>
<th>Gender</th>
<th>Salary</th>
</tr>

<%
for (Employee e : list) {
%>
<tr>
<td><%= e.getEmpno() %></td>
<td><%= e.getEmpName() %></td>
<td><%= e.getDoj() %></td>
<td><%= e.getGender() %></td>
<td><%= e.getBsalary() %></td>
</tr>
<%
}
%>

</table>

<%
} else {
%>
<p>No records found</p>
<%
}
%>

</body>
</html>