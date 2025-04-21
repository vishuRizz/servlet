package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    // Serve a simple HTML registration form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                  <meta charset="UTF-8">
                  <title>Registration</title>
                </head>
                <body>
                  <h2>User Registration</h2>
                  <form method="post" action="register">
                    <label>First Name: <input type="text" name="firstName" required></label><br><br>
                    <label>Last Name:  <input type="text" name="lastName" required></label><br><br>
                    <label>Email:      <input type="email" name="email" required></label><br><br>
                    <label>Password:   <input type="password" name="password" required></label><br><br>
                    <button type="submit">Register</button>
                  </form>
                </body>
                </html>
                """);
        }
    }

    // Process the submitted form data
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Read parameters from the request
        String firstName = req.getParameter("firstName");
        String lastName  = req.getParameter("lastName");
        String email     = req.getParameter("email");
        String password  = req.getParameter("password");

        // (In a real app you'd validate & store these in a database)

        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                  <meta charset="UTF-8">
                  <title>Registration Result</title>
                </head>
                <body>
                  <h2>Registration Successful</h2>
                """);
            out.printf("<p>Name: %s %s</p>%n", firstName, lastName);
            out.printf("<p>Email: %s</p>%n", email);
            out.println("""
                  <p><a href="register">Back to form</a></p>
                </body>
                </html>
                """);
        }
    }
}
