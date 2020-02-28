<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function greet(){
	alert("Send OTP to your email-id...");
}
</script>
<%String email="";
int value = 0;
String login="";
String error="";
String message="SendOtp";
User obj1 = (User)request.getAttribute("nw");
Object errormsg =request.getAttribute("error");
if(obj1!=null){
	message="ResendOtp";
	email=obj1.getEmail();
	login=obj1.getLogin_id();
	value = 1;
}
if(errormsg!=null)
	error = (String)errormsg;

%>
<h3 style="background-color:black;color:white;width:20%; text-align:center"><%=error%></h3>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</body>
<%if(value==0) {%>
<center>
<form action="PasswordRecovery" method="post" border="2">
Login_id:<br>
<input type="text" name="log" value="<%=login %>"><br>
Email_id:<br>
<input type="text" name="mail" value="<%=email %>"><br>
<button name="button" onclick="greet()" value="1">
<%=message %></button><br>
</form></center>
<%} else{%>
<center>
<form action="PasswordRecovery" method="post" border="2">
<table width="100%">
<tr>
<th>Login_Id:</th>
<td><input type="text" name="log" value="<%=login %>"></td>
</tr>
<tr>
<th>Email_Id:</th>
<td><input type="text" name="mail" value="<%=email %>"></td>
</tr><br>
<tr>
<th>OTP:</th><td><input type="password" name="sentotp"></td></tr>
<tr><th>New Password:</th><td><input type="password" name="newpass"></td></tr>
<tr><th>Confirm Password:</th><td><input type="password" name="cnfpass"></td></tr>
<tr>
<td><button name="button" onclick="greet()" value="1">
<%=message %></button></td>
<td><input type="submit" value="Submit"></td>
</tr><br>
</table>
</form>
</center>
<%} %>

</html>