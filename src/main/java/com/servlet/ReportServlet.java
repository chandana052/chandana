package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    // 🔹 Handle GET (avoid blank page)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h3>Please generate report using the form</h3>");
    }

    // 🔹 Handle POST (main logic)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String reportType = request.getParameter("reportType");

            EmployeeDAO dao = new EmployeeDAO();
            List<Employee> list = null;

            // 🔹 Report 1: Name starts with letter
            if ("name".equals(reportType)) {
                String letter = request.getParameter("letter");

                if (letter == null || letter.isEmpty()) {
                    request.setAttribute("error", "Enter starting letter!");
                    request.getRequestDispatcher("report_form.jsp").forward(request, response);
                    return;
                }

                list = dao.getByName(letter);
            }

            // 🔹 Report 2: Experience
            else if ("experience".equals(reportType)) {
                String yearsStr = request.getParameter("years");

                if (yearsStr == null || yearsStr.isEmpty()) {
                    request.setAttribute("error", "Enter years!");
                    request.getRequestDispatcher("report_form.jsp").forward(request, response);
                    return;
                }

                int years = Integer.parseInt(yearsStr);
                list = dao.getByExperience(years);
            }

            // 🔹 Report 3: Salary
            else if ("salary".equals(reportType)) {
                String salaryStr = request.getParameter("salary");

                if (salaryStr == null || salaryStr.isEmpty()) {
                    request.setAttribute("error", "Enter salary!");
                    request.getRequestDispatcher("report_form.jsp").forward(request, response);
                    return;
                }

                double salary = Double.parseDouble(salaryStr);
                list = dao.getBySalary(salary);
            }

            // 🔹 Send result to JSP
            request.setAttribute("reportList", list);
            RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input!");
            request.getRequestDispatcher("report_form.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error generating report!");
            request.getRequestDispatcher("report_form.jsp").forward(request, response);
        }
    }
}