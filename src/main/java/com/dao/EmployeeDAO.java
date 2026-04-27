package com.dao;

import java.sql.*;
import java.util.*;
import com.model.Employee;

public class EmployeeDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/employee_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    // 🔹 DB Connection
    protected Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // 🔹 ADD EMPLOYEE
    public void addEmployee(Employee emp) throws Exception {

        String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getEmpName());
            ps.setDate(3, new java.sql.Date(emp.getDoj().getTime()));
            ps.setString(4, emp.getGender());
            ps.setDouble(5, emp.getBsalary());

            ps.executeUpdate();
        }
    }

    // 🔹 UPDATE EMPLOYEE
    public void updateEmployee(Employee emp) throws Exception {

        String sql = "UPDATE Employee SET EmpName=?, DoJ=?, Gender=?, Bsalary=? WHERE Empno=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getEmpName());
            ps.setDate(2, new java.sql.Date(emp.getDoj().getTime()));
            ps.setString(3, emp.getGender());
            ps.setDouble(4, emp.getBsalary());
            ps.setInt(5, emp.getEmpno());

            ps.executeUpdate();
        }
    }

    // 🔹 DELETE EMPLOYEE
    public void deleteEmployee(int empno) throws Exception {

        String sql = "DELETE FROM Employee WHERE Empno=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empno);
            ps.executeUpdate();
        }
    }

    // 🔹 GET EMPLOYEE BY ID
    public Employee getEmployee(int empno) throws Exception {

        Employee emp = null;

        String sql = "SELECT * FROM Employee WHERE Empno=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employee(
                        rs.getInt("Empno"),
                        rs.getString("EmpName"),
                        rs.getDate("DoJ"),
                        rs.getString("Gender"),
                        rs.getDouble("Bsalary")
                );
            }
        }
        return emp;
    }

    // 🔹 REPORT 1: NAME STARTS WITH
    public List<Employee> getByName(String letter) throws Exception {

        List<Employee> list = new ArrayList<>();

        String sql = "SELECT * FROM Employee WHERE EmpName LIKE ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, letter + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("Empno"),
                        rs.getString("EmpName"),
                        rs.getDate("DoJ"),
                        rs.getString("Gender"),
                        rs.getDouble("Bsalary")
                ));
            }
        }
        return list;
    }

    // 🔹 REPORT 2: EXPERIENCE
    public List<Employee> getByExperience(int years) throws Exception {

        List<Employee> list = new ArrayList<>();

        String sql = "SELECT * FROM Employee WHERE TIMESTAMPDIFF(YEAR, DoJ, CURDATE()) >= ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, years);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("Empno"),
                        rs.getString("EmpName"),
                        rs.getDate("DoJ"),
                        rs.getString("Gender"),
                        rs.getDouble("Bsalary")
                ));
            }
        }
        return list;
    }

    // 🔹 REPORT 3: SALARY
    public List<Employee> getBySalary(double salary) throws Exception {

        List<Employee> list = new ArrayList<>();

        String sql = "SELECT * FROM Employee WHERE Bsalary > ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("Empno"),
                        rs.getString("EmpName"),
                        rs.getDate("DoJ"),
                        rs.getString("Gender"),
                        rs.getDouble("Bsalary")
                ));
            }
        }
        return list;
    }
}