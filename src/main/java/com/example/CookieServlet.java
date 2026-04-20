package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 1;

        // Get existing cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }
            }
        }

        // Create/Update visit count cookie
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCookie.setMaxAge(30); // expires in 30 seconds (for demo)
        response.addCookie(visitCookie);

        // Create name cookie
        Cookie nameCookie = new Cookie("username", name);
        nameCookie.setMaxAge(30); // expires in 30 seconds
        response.addCookie(nameCookie);

        // Output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");

        // Display all cookies
        out.println("<h3>Cookies List:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + "<br>");
                out.println("Value: " + c.getValue() + "<br><br>");
            }
        }

        out.println("<p><b>Note:</b> Cookies will expire in 30 seconds. Refresh after 30s to see reset.</p>");

        out.println("</body></html>");
    }
}