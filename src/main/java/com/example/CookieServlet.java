package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");

        Cookie cookies[] = request.getCookies();
        int count = 1;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        Cookie visit = new Cookie("visitCount", String.valueOf(count));
        visit.setMaxAge(30); // expires in 30 sec
        response.addCookie(visit);

        PrintWriter out = response.getWriter();
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You visited " + count + " times</h3>");
    }
}