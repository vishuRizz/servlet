<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>User Registration</title></head>
<body>
<h2>User Registration Form</h2>
<form action="submitRegistration" method="post">
    First Name: <input type="text" name="firstName" required><br><br>
    Last Name: <input type="text" name="lastName" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
