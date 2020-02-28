<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
   <meta charset="utf-8">
   <link rel="stylesheet" href="css/style.css">
</head>
<body>
      <form class="box" action="clientlogin" method="post">
	  <h1>Client Login</h1>
	  <input type="text" name="username"placeholder="Username">
	  <input type="password" name="password" placeholder="Password">
	  <input type="submit" name=""value="Login"><br><br>
	  <a href="client_forgot_password.jsp" style="color:white">FORGET PASSWORD</a>
	</form>
</body>
</html>