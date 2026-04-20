package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        // Server-side validation
        if (name.isEmpty() || email.isEmpty() || designation.isEmpty()) {
            out.println("<h2>Error: All fields required</h2>");
            return;
        }

        if (!email.contains("@")) {
            out.println("<h2>Error: Invalid Email</h2>");
            return;
        }

        // Display result
        out.println("<html><body>");
        out.println("<h2>User Details</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Designation: " + designation + "<br><br>");

        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}