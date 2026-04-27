package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import java.text.SimpleDateFormat;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {

    // 🔹 Handle GET (avoid blank/404 issues)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h3>Please update employee using the form</h3>");
    }

    // 🔹 Handle POST (main logic)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get parameters
            String empnoStr = request.getParameter("empno");
            String name = request.getParameter("empName");
            String dojStr = request.getParameter("doj");
            String gender = request.getParameter("gender");
            String salaryStr = request.getParameter("bsalary");

            // Validation
            if (empnoStr == null || empnoStr.isEmpty() ||
                name == null || name.isEmpty() ||
                dojStr == null || dojStr.isEmpty() ||
                salaryStr == null || salaryStr.isEmpty()) {

                response.getWriter().println("<h3>All fields are required!</h3>");
                return;
            }

            int empno = Integer.parseInt(empnoStr);
            double salary = Double.parseDouble(salaryStr);

            if (salary < 0) {
                response.getWriter().println("<h3>Salary must be positive!</h3>");
                return;
            }

            // Convert date
            java.util.Date doj = new SimpleDateFormat("yyyy-MM-dd").parse(dojStr);

            // Create object
            Employee emp = new Employee(empno, name, doj, gender, salary);

            // DAO call
            EmployeeDAO dao = new EmployeeDAO();
            dao.updateEmployee(emp);

            // Success message
            response.setContentType("text/html");
            response.getWriter().println("<h3>Employee Updated Successfully!</h3>");
            response.getWriter().println("<a href='index.jsp'>Go Back</a>");

        } catch (NumberFormatException e) {
            response.getWriter().println("<h3>Invalid number format!</h3>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error updating employee!</h3>");
        }
    }
}