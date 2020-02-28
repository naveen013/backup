<%@ include file="Header.jsp" %>
<%@page import="stu.hub.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

form{
width:500px;
height:350px;
margin:auto;
}
</style>
</head>
<body>
<%if(u!=null){ %>
<center>
<fieldset style="width:70%;background-color: #45d4de;"><legend style="font-size: 20px">Books</legend>

<form action="bookcontroller.jsp" method="post">
<table width="100%" height="300">
	
	<tr>
		<td><font face="cilbri" size="4">Book Type*</td>
		<td>
		<select name="btype">
			<option value="none">Select Book</option>
			<option value="Architecture">Architecture</option>
			<option value="Autometa">Autometa</option>
			<option value="Computer">Computer</option>
			<option value="Programming">Programming</option>
			<option value="OperatingSysyem">Operating Sysyem</option>
			<option value="Physics">Physics</option>
			<option value="Chesmistry">Chesmistry</option>
			<option value="Math">MAHTEMATICS</option>
			<option value="Biology">Biology</option>
			<option value="Nobel">Nobel</option>
			<option value="English">English</option>
			<option value="Reasoning">Reasoning</option>
			</select>
		</td>
	</tr>
		<tr>
		<td><font face="cilbri" size="4">Subtopic*</td>
		<td><input type="text" name="spe" placeholder="specialization"></td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Book Name*</td>
		<td><input type="text" name="bname" placeholder="enter book name"></td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Author Name</td>
		<td><input type="text" name="author" placeholder="enter author"></td>
	</tr>
	
	<tr>
		<td>
		</td>
		<td>
		<input type="submit" name="submit">
		</td>
	</tr>
</table>
</form>
</fieldset>
</center>
<%}else{ %>
<br>
<center>
<h1>Please Login First</h1>
<hr>
<h1>
<a href="login.jsp" style="text-decoration:none;color:green;">Login</a>
</h1>
</center>
<%} %>


</body>
</html>