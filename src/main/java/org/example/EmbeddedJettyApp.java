package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class EmbeddedJettyApp {
    public static void main(String[] args) throws Exception {
        // Create a Jetty server on port 8080
        Server server = new Server(8080);

        // Set up a servlet context handler
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Map the RegistrationServlet to the /register URL
        context.addServlet(new ServletHolder(new RegistrationServlet()), "/register");

        // Start the server
        server.start();
        System.out.println("Server started on http://localhost:8080/register");
        server.join();
    }
}
