package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    // Serve a simple HTML registration form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("""
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

    // Process submitted data and forward to success.jsp
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName  = req.getParameter("lastName");
        String email     = req.getParameter("email");

        // Set attributes to pass to JSP
        req.setAttribute("firstName", firstName);
        req.setAttribute("lastName", lastName);
        req.setAttribute("email", email);

        // Forward to success.jsp
        req.getRequestDispatcher("/success.jsp").forward(req, resp);
    }
}
