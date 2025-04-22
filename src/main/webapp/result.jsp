<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String firstName = request.getParameter("firstName");
    String lastName  = request.getParameter("lastName");
    String email     = request.getParameter("email");
%>
<html>
<head>
    <title>Registration Success</title>
</head>
<body style="font-family:sans-serif;">
    <h2>Registration Successful 🎉</h2>
    <p>Welcome, <strong><%= firstName %> <%= lastName %></strong></p>
    <p>Email: <%= email %></p>
    <a href="register.jsp">Back to Form</a>
</body>
</html>
