package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class EmbeddedJettyApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Register all servlets
        context.addServlet(new ServletHolder(new HelloServlet()), "/");
        context.addServlet(new ServletHolder(new RegistrationServlet()), "/register");
        context.addServlet(new ServletHolder(new MessageWithDateServlet()), "/message");
        context.addServlet(new ServletHolder(new RandomNumberServlet()), "/random");

        server.start();
        System.out.println("Server started at:");
        System.out.println("  http://localhost:8080/");
        System.out.println("  http://localhost:8080/register");
        System.out.println("  http://localhost:8080/message");
        System.out.println("  http://localhost:8080/random");
        server.join();
    }
}
