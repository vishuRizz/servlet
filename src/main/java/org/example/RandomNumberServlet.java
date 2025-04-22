package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/random")
public class RandomNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        int number = new Random().nextInt(100); // 0 to 99

        try (PrintWriter out = resp.getWriter()) {
            out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                  <meta charset="UTF-8">
                  <title>Random Number</title>
                  <style>
                    body {
                      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                      background-color: #eef2f7;
                      margin: 0;
                      padding: 40px;
                      text-align: center;
                      color: #222;
                    }
                    .card {
                      background-color: #fff;
                      padding: 40px;
                      margin: auto;
                      width: 50%;
                      border-radius: 10px;
                      box-shadow: 0 6px 12px rgba(0,0,0,0.1);
                    }
                    .number {
                      font-size: 60px;
                      font-weight: bold;
                      color: #28a745;
                    }
                    a {
                      display: inline-block;
                      margin-top: 25px;
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
                  <div class="card">
                    <h1>🎲 Your Random Number</h1>
                """);
            out.printf("<div class=\"number\">%d</div>%n", number);
            out.println("""
                    <a href="/message">Go Back to Welcome Page</a>
                  </div>
                </body>
                </html>
                """);
        }
    }
}
