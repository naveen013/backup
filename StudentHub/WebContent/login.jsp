<%@ include file="Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String forgotpass=(String)request.getAttribute("forgot"); 
String user="";
String pass="";%>
<%
String msg1 = (String)request.getAttribute("invalid");
String msg2 = (String)request.getAttribute("invalpass");
if(msg1!=null)
	user=msg1;
if(msg2!=null)
	pass=msg2;
%>
<%String emptyfield=(String)request.getAttribute("empty"); 
 if(emptyfield!=null){%>
<%=emptyfield %>
<%} %>
<div id="project_main">
		<br>
				<form action="login" method="post">
				 <div class="imgcontainer">
    				<img src="images\loginPic.png" alt="pic" class="avatar">
  				</div>
  				<div class="container">
					<label for="user_name"><b>Username</b></label><br>
    				<input type="text" placeholder="Enter Username" name="user_name" required>
    				<br>
    				<label for="password"><b>Password</b></label><br>
    				<input type="password" placeholder="Enter Password" name="password" required>
					<br>
					<button type="submit" >Login</button><br><br>
					<%//if(forgotpass!=null){ %>
					<center>
					<tr><th><a href="passrecovery.jsp">Forgotpassword?</a></th>
					<%if(forgotpass!=null) {%>
					<td><%=forgotpass %></td>
					<%} %>
					
					</tr>
					</center>
					<%//} %>
				</table>
			</form>
			</div>
	<div id="project_footer">
		www.studenthub.org.in
	</div>

</body>
</html>