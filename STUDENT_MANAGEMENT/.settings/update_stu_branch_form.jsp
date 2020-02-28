<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <%
   Branch branch  = (Branch)request.getAttribute("branch");
%>

<form action="updatebranch" method="post">
BRANCH ID <input  name="branchid" type="text" value="<%=branch.getId() %>" readonly="readonly"><br> 
BRANCH NAME<input  name="branchname" type="text" value="<%=branch.getName() %>"><br>
HOD<input name="branchhod" "type="text"  value="<%=branch.getHod() %>"><br>
<input type="submit" value="update"> 	
</body>
</html>