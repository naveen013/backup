<%@page import="nit.com.bo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <%
        Customer cust = (Customer)request.getAttribute("cust");
  %>
    <fieldset><legend>Student Detail</legend>
    USERNAME:<%=cust.getUsername() %><br>
    PASSWORD :<%=cust.getPassword()%><br>
        EMAIL:     <%=cust.getEmail()%><br>
       MOBILE:<%=cust.getMobile()%><br>
       GENDER:<%=cust.getGender()%><br>
      ADDRESS:<%=cust.getAddress()%><br>
    </fieldset>
    <a href ="home.jsp" >back to home</a>
</body>
</html>