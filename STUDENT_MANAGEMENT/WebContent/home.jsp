<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<title>Insert title here</title>

<%
 User user2  = null;
   if(session.getAttribute("user2")!=null){
	   user2  = (User)session.getAttribute("user2");
   }

%>

<%if(user2!=null){ %>
   <%=user2.getName() %><br>
   <%=user2.getRole()%>
   
    welcome to home<hr>
     <a href="branch"> SHOW ALL BRANCH</a><br><br><hr>
     <a href="student">SHOW ALL STUDENT</a><br><br><hr>
     <a href="studentserch">SERCH STUDENT BY ID</a><br><br><hr>
     <a href="stubranchserch">SERCH BRANCH BY ID</a><br><br><hr>
     <a href="add_stu_form.jsp">ADD STUDENT</a> <hr>
   
	<a href="logout">Logout</a>
<%}else{ %>
	<a href="login.jsp">Login</a>
<%} %>
<hr>

    
</body>
</html>