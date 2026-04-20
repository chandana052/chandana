package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String roll = request.getParameter("roll");
            String name = request.getParameter("name");

            int s1 = Integer.parseInt(request.getParameter("s1"));
            int s2 = Integer.parseInt(request.getParameter("s2"));
            int s3 = Integer.parseInt(request.getParameter("s3"));
            int s4 = Integer.parseInt(request.getParameter("s4"));
            int s5 = Integer.parseInt(request.getParameter("s5"));

            // Server validation
            if (roll.isEmpty() || name.isEmpty()) {
                out.println("<h2>Error: Fill all fields</h2>");
                return;
            }

            // Calculate
            int total = s1 + s2 + s3 + s4 + s5;
            double avg = total / 5.0;

            String result = (s1 >= 40 && s2 >= 40 && s3 >= 40 && s4 >= 40 && s5 >= 40)
                    ? "PASS" : "FAIL";

            // Output
            out.println("<html><body>");
            out.println("<h2>Result</h2>");
            out.println("Roll No: " + roll + "<br>");
            out.println("Name: " + name + "<br>");
            out.println("Average: " + avg + "<br>");
            out.println("Result: " + result + "<br><br>");

            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<h2>Error: Invalid Input</h2>");
        }
    }
}