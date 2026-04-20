package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        int time = Integer.parseInt(request.getParameter("time"));

        HttpSession session = request.getSession(true);

        // Set session expiry (minutes → seconds)
        session.setMaxInactiveInterval(time * 60);

        // Store name
        session.setAttribute("username", name);

        out.println("<html><body>");
        out.println("<h2>Hello " + name + "!</h2>");
        out.println("<p>Session will expire in " + time + " minute(s).</p>");

        // Link to check session
        out.println("<a href='CheckServlet'>Click here to check session</a>");

        out.println("</body></html>");
    }
}