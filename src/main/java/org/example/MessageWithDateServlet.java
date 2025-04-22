package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/message")
public class MessageWithDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            String currentTime = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm:ss"));

            out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                  <meta charset="UTF-8">
                  <title>Welcome Message</title>
                  <style>
                    body {
                      font-family: Arial, sans-serif;
                      background-color: #f4f4f9;
                      margin: 0;
                      padding: 40px;
                      text-align: center;
                      color: #333;
                    }
                    .container {
                      background-color: #fff;
                      padding: 30px;
                      margin: auto;
                      width: 60%;
                      border-radius: 8px;
                      box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                    }
                    a {
                      display: inline-block;
                      margin-top: 20px;
                      text-decoration: none;
                      color: #007BFF;
                      font-weight: bold;
                    }
                    a:hover {
                      text-decoration: underline;
                    }
                  </style>
                </head>
                <body>
                  <div class="container">
                    <h1>👋 Welcome to Our Site!</h1>
                    <p>Current Date and Time:</p>
                """);
            out.printf("<h2>%s</h2>%n", currentTime);
            out.println("""
                    <a href="/random">Generate a Random Number</a>
                  </div>
                </body>
                </html>
                """);
        }
    }
}
