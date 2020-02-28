<%@page import="stu.hub.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentHub</title>
</head>
	<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div id="header">
			<div class="side"><center><img src="images/logo.png"height=100px/></center></div>
			<h1>Student Hub</h1>
			<%User u = null;
			if(session.getAttribute("usr")!=null){
			u= (User)session.getAttribute("usr");
			}%>
			
			<div class="side2">
			<%if(u!=null){ %>
			<center>
			<bold><%=u.getName() %></bold><br>
			<bold><a href="logout"style="color:black;font-size:20px;">LOGOUT</a></bold>
			</center>
			<%}else{%>
			
				<center ><a href="login.jsp"style="color:black;font-size:20px;">LOGIN</a><br>
				<a style="color:black;font-size:20px" href="signup.jsp">SIGNUP</a><%} %></center></div>
		</div>
<br clear="all">
	<div class="menudropdown">
		<ul>
			<li><a href="Home.jsp">HOME</a></li>
			<li><a href="AboutUs.jsp">ABOUT US</a></li>
			<li>SERVICES
			<ul>
				<li><a href="laptop.jsp">Laptop-Repair</a></li>
				<li><a href="to_let.jsp">TO-LET</a></li></li>
				<li><a href="book.jsp">BOOKS</a></li>
				<li><a href="stuff.jsp">BUY STUFFS</a></li>
			</ul></li>
			<li><a href="#">News/Update</a></li>
			<li>SELL
			<ul>
			<li><a href="laptopsell.jsp">LAPTOP-SELL</a></li>
				<li><a href="to_let_owner.jsp">TO-LET</a></li>
				<li><a href="sellbook.jsp">BOOKS</a></li>
				<li><a href="stuff_sell.jsp">SELL STUFFS</a></li>
			</ul>
			</li>

		</ul>

	</div>
	<br clear="all">
</body>
</html>