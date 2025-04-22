package org.example;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <html>
                <head><title>Register</title></head>
                <body>
                  <h2>User Registration</h2>
                  <form method='post' action='/submitRegistration'>
                    First Name: <input type='text' name='firstName' required><br><br>
                    Last Name: <input type='text' name='lastName' required><br><br>
                    Email: <input type='email' name='email' required><br><br>
                    <button type='submit'>Register</button>
                  </form>
                </body>
                </html>
                """);
    }
}
