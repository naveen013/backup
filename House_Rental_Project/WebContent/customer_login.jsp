<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
   <meta charset="utf-8">
   <link rel="stylesheet" href="css/style.css">
</head>
<body>
      <form class="box" action="customerlogin" method="post">
	  <h1>Customer Login</h1>
	  <input type="text" name="username"placeholder="Username">
	  <input type="password" name="password" placeholder="Password">
	  <input type="submit" name=""value="Login"><br>
	     <a href="customer_forget_password.jsp"><button>Forget password</button></a>
	</form>
</body>
</html>