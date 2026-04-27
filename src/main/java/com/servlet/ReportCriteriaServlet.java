package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ReportCriteriaServlet")
public class ReportCriteriaServlet extends HttpServlet {

    // 🔹 Handle GET (optional)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h3>Please select report criteria from form</h3>");
    }

    // 🔹 Handle POST (main logic)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String reportType = request.getParameter("reportType");

            // 🔹 Validation
            if (reportType == null || reportType.isEmpty()) {
                request.setAttribute("error", "Please select report type!");
                request.getRequestDispatcher("report_form.jsp").forward(request, response);
                return;
            }

            // 🔹 Forward to ReportServlet with same request
            RequestDispatcher rd = request.getRequestDispatcher("ReportServlet");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error processing report criteria!");
            request.getRequestDispatcher("report_form.jsp").forward(request, response);
        }
    }
}