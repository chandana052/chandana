package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import java.text.SimpleDateFormat;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {

    // 🔹 Handles GET request (when URL is opened directly)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h3>Please submit the form from empadd.jsp</h3>");
    }

    // 🔹 Handles POST request (form submission)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get form data
            int empno = Integer.parseInt(request.getParameter("empno"));
            String name = request.getParameter("empName");
            String doj = request.getParameter("doj");
            String gender = request.getParameter("gender");
            double salary = Double.parseDouble(request.getParameter("bsalary"));

            // Convert date
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(doj);

            // Create object
            Employee emp = new Employee(empno, name, date, gender, salary);

            // DAO call
            EmployeeDAO dao = new EmployeeDAO();
            dao.addEmployee(emp);

            // Success message
            response.setContentType("text/html");
            response.getWriter().println("<h3>Employee Added Successfully!</h3>");
            response.getWriter().println("<a href='index.jsp'>Go Back</a>");

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h3>Error adding employee!</h3>");
        }
    }
}