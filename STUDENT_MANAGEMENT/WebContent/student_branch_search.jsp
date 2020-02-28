<%@include file="header.jsp" %>
<%@page import="sis.com.bo.Branch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <%
      List<Branch>list = (List<Branch>)request.getAttribute("branchlist");
  %>
  <form action="stubranchserch" method="post">
  SELECT BRANCH
  <select name="BranchId">
        <%for(Branch branch : list) {%>
		<option value='<%=branch.getId()%>'> name='<%=branch.getName() %>'  [<%=branch.getId()%>]</option>
	 <%} %>	
  
  </select>
  <input type="submit" value="search">
  </form>

</body>
</html>