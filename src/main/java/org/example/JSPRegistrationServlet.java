package org.example;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/submitRegistration")
public class JSPRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        resp.setContentType("text/html");
        resp.getWriter().println("""
                <html>
                <head><title>Registration Result</title></head>
                <body>
                  <h2>Registration Successful!</h2>
                  <p>First Name: """ + firstName + "</p>" +
                  "<p>Last Name: " + lastName + "</p>" +
                  "<p>Email: " + email + "</p>" +
                "</body></html>");
    }
}
