package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDAO;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {

    // 🔹 Handle GET (avoid blank page)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h3>Please delete employee using the form</h3>");
    }

    // 🔹 Handle POST (main logic)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get parameter
            String empnoStr = request.getParameter("empno");

            // Validation
            if (empnoStr == null || empnoStr.isEmpty()) {
                response.getWriter().println("<h3>Employee ID is required!</h3>");
                return;
            }

            int empno = Integer.parseInt(empnoStr);

            // DAO call
            EmployeeDAO dao = new EmployeeDAO();
            dao.deleteEmployee(empno);

            // Success message
            response.setContentType("text/html");
            response.getWriter().println("<h3>Employee Deleted Successfully!</h3>");
            response.getWriter().println("<a href='index.jsp'>Go Back</a>");

        } catch (NumberFormatException e) {
            response.getWriter().println("<h3>Invalid Employee ID!</h3>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error deleting employee!</h3>");
        }
    }
}