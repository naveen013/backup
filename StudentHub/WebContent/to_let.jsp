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
height:440px;
margin:auto;
}


</style>
</head>
<body>
<%if(u!=null){ %>
<center>
<fieldset style="width:70%;background-color: #45d4de;"><legend style="font-size: 20px">TO-LET</legend>
<form action="RoomController" method="post">
<table width="100%" height="400"  >
	<tr>
		<td colspan="2" ><font face="cilbri" size="5">
		<center>Search your Room/Flat Here</center>
		</td>
	</tr>
	
	<tr>
	<td colspan="2">Loation : Place Where You Want Room/Flats</td></tr>
	
	<tr>
	<td>
	<font face="cilbri" size="4">Location :</td>
		<td>
		<textarea name="addr" row="3" cols="22"></textarea>
		</td>
	</tr>
		<tr>
		<td><font face="cilbri" size="4">Contact No.</td>
		<td><input type="text" name="contactNo" placeholder="enter mob. no."></td>
	</tr>
	<tr>
		<td><font face="cilbri" size="4">Accommodation Type</td>
		<td>
		<select name="flat">
		<option value="1bhk">1BHK</option>
		<option value="2bkh">2BHK</option>
		<option value="3bhk">3BHK</option>
		</select>
		
		</td>
	 </tr>
	<tr>
		<td>Enter Your Budget</td>	
		<td>
		<input type="text" name="price"  placeholder="enter price">
		</td>
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