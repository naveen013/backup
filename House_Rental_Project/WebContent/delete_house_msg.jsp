<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <h1><a href="#"><b><--Back to Owner View</b></a></h1>
    <%
      Object obj = request.getAttribute("delete_msg");
    %>
    <h1 align="center"><b>Delete message  <%=obj%></b></h1><br><br>
</body>
</html>