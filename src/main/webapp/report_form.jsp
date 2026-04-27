<html>
<head>
<script>
function showFields() {
    let type = document.getElementById("reportType").value;

    document.getElementById("letterDiv").style.display = "none";
    document.getElementById("yearsDiv").style.display = "none";
    document.getElementById("salaryDiv").style.display = "none";

    if (type == "name") document.getElementById("letterDiv").style.display = "block";
    if (type == "experience") document.getElementById("yearsDiv").style.display = "block";
    if (type == "salary") document.getElementById("salaryDiv").style.display = "block";
}
</script>
</head>

<body onload="showFields()">
<h2>Select Report</h2>

<form action="ReportCriteriaServlet" method="post">

<select name="reportType" id="reportType" onchange="showFields()">
    <option value="name">Name Starts With</option>
    <option value="experience">Experience</option>
    <option value="salary">Salary</option>
</select><br><br>

<div id="letterDiv">
Enter Letter: <input type="text" name="letter">
</div>

<div id="yearsDiv">
Enter Years: <input type="text" name="years">
</div>

<div id="salaryDiv">
Enter Salary: <input type="text" name="salary">
</div>

<br>
<input type="submit" value="Generate Report">

</form>

</body>
</html>