<%@page import="nit.com.bo.Branch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
        <%
        Branch branch = (Branch)request.getAttribute("branch");
  %>
    <fieldset style="width:270px"><legend>Branch Detail</legend>
    BranchId:<%=branch.getId() %><br>
    BranchName:<%=branch.getName() %><br>
    Hod:<%=branch.getHod() %><br>
    </fieldset>
    <a href ="home.jsp" >back to home</a>
</body>
</html>