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
<fieldset style="width:70%;background-color: #45d4de;"><legend style="font-size: 20px">STUFF</legend>
<form action="StuffController" method="post">
<table width="100%" height="300px" >
	<tr>
		<td colspan="2" ><font face="cilbri" size="5">
		<center>Detail of Daily Stuff</center>
		</td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Items</td>
		<td><select name="item_name">
		<option value="none">Select Name</option>
		<option value="Laptop">Laptop</option>
		<option value="table">Table</option>
		<option value="chair">Chair</option>
		<option value="other">Others</option>
		</select>
		
		</td>
	</tr>
		<tr>
		<td><font face="cilbri" size="4">Item Name*(if[Others])</td>
		<td><textarea  name="other" row="3" cols="22"></textarea></td>
	</tr>
		<tr>
		<td><font face="cilbri" size="4">Contact No.</td>
		<td><input type="text" name="mob_no" placeholder="enter mob. no."></td>
	</tr>
		
	<tr>
	<td>
		</td>
		<td>
		<input type="submit" value="submit">
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