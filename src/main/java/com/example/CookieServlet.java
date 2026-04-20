package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html><body>");
        out.println("<h2>Active Cookie List</h2>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + "<br>");
                out.println("Value: " + c.getValue() + "<br><br>");
            }
        } else {
            out.println("No cookies found");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String domain = request.getParameter("domain");
        int age = Integer.parseInt(request.getParameter("age"));

        // Create cookie
        Cookie cookie = new Cookie(name, domain);

        // Set expiry time
        cookie.setMaxAge(age);

        response.addCookie(cookie);

        out.println("<html><body>");
        out.println("<h2>Cookie Added Successfully</h2>");

        out.println("Name: " + name + "<br>");
        out.println("Domain(Value): " + domain + "<br>");
        out.println("Expiry: " + age + " seconds<br><br>");

        // SAME servlet used to show cookies
        out.println("<a href='CookieServlet'>Go to Active Cookie List</a>");

        out.println("</body></html>");
    }
}