package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        // Create session
        HttpSession session = request.getSession(true);

        // Set session expiry to 1 minute
        session.setMaxInactiveInterval(60);

        session.setAttribute("username", name);

        out.println("<html><body>");
        out.println("<h2>Hello " + name + "!</h2>");
        out.println("<p>Session will expire after 1 minute of inactivity.</p>");

        out.println("</body></html>");
    }
}