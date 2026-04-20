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

        // Get or create session
        HttpSession session = request.getSession(true);

        // Set session expiry time = 1 minute
        session.setMaxInactiveInterval(60);

        String name = request.getParameter("username");

        // Store name in session if first time
        if (session.isNew() || session.getAttribute("username") == null) {
            session.setAttribute("username", name);
        } else {
            name = (String) session.getAttribute("username");
        }

        // Output
        out.println("<html><body>");

        out.println("<h2>Hello " + name + "!</h2>");

        out.println("<h3>Session Details:</h3>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Creation Time: " + new Date(session.getCreationTime()) + "<br>");
        out.println("Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br>");

        out.println("<p><b>Note:</b> Session expires after 1 minute of inactivity.</p>");

        out.println("</body></html>");
    }
}