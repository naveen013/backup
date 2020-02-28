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
height:500px;
margin:auto;
}
</style>
</head>
<body>
<%//if(u!=null){ %>
<center>
<fieldset style="width:70%;background-color: #45d4de;"><legend style="font-size: 20px">Books Sell</legend>

<form action="BookSellController" method="post">
<table width="100%">
	<tr>
		<td colspan="2" ><font face="cilbri" size="5">
		<center>Sell Your Books Here</center>
		</td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">FULL Name</td>
		<td><input type="text" name="owner" placeholder="Your Full Name"></td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Contact No:</td>
		<td><input type="text" name="contact" placeholder="Your Contact No"></td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Email_Id:</td>
		<td><input type="text" name="email" placeholder="Your Email-Id"></td>
	</tr>
	
	<tr>
		<td><font face="cilbri" size="4">Book Type*</td>
		<td>
		<select name="btype">
			<option value="none">Select Book</option>
			<option value="Architecture">Architecture</option>
			<option value="Autometa">Automata</option>
			<option value="Computer">Computer</option>
			<option value="Programming">Programming</option>
			<option value="OperatingSysyem">Operating System</option>
			<option value="Physics">Physics</option>
			<option value="Chesmistry">Chemistry</option>
			<option value="Math">Math</option>
			<option value="Biology">Biology</option>
			<option value="Nobel">Novel</option>
			<option value="English">English</option>
			<option value="Reasoning">Reasoning</option>
			</select>
		</td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Book Name*</td>
		<td><input type="text" name="bname" placeholder="enter book name"></td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Author Name</td>
		<td><input type="text" name="aname" placeholder="enter author"></td>
	</tr>

	<tr>
		<td><font face="cilbri" size="4">Selling Price:</td>
		<td><input type="number" name="price" placeholder="booksellprice" class="input_style"></td>
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
<%//}else{// %>
<br>
<!--  <center>
<h1>Please Login First</h1>
<hr>
<h1>
<a href="login.jsp" style="text-decoration:none;color:green;">Login</a>
</h1>
</center>-->
<%//}// %>
	<div id="project_footer"></div>

</body>
</html>