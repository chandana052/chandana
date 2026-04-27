package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

@WebServlet("/DisplayEmployeeServlet")
public class DisplayEmployeeServlet extends HttpServlet {

    // 🔹 Handle GET (avoid blank page)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h3>Please search employee using the form</h3>");
    }

    // 🔹 Handle POST (main logic)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get parameter
            String empnoStr = request.getParameter("empno");

            // Validation
            if (empnoStr == null || empnoStr.isEmpty()) {
                request.setAttribute("error", "Employee ID is required!");
                request.getRequestDispatcher("empdisplay.jsp").forward(request, response);
                return;
            }

            int empno = Integer.parseInt(empnoStr);

            // DAO call
            EmployeeDAO dao = new EmployeeDAO();
            Employee emp = dao.getEmployee(empno);

            if (emp != null) {
                request.setAttribute("employee", emp);
            } else {
                request.setAttribute("error", "Employee not found!");
            }

            // Forward to JSP
            RequestDispatcher rd = request.getRequestDispatcher("empdisplay.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid Employee ID!");
            request.getRequestDispatcher("empdisplay.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error fetching employee!");
            request.getRequestDispatcher("empdisplay.jsp").forward(request, response);
        }
    }
}