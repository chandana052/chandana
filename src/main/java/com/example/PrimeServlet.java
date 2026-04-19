package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));
        boolean isPrime = true;

        if (num <= 1) isPrime = false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        PrintWriter out = response.getWriter();

        if (isPrime)
            out.println("<h2>" + num + " is Prime</h2>");
        else
            out.println("<h2>" + num + " is NOT Prime</h2>");
    }
}