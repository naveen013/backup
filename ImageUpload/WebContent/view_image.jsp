<%@page import="java.util.List"%>
<%@page import="nit.com.bo.Employe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
     <% 
        Object obj = request.getAttribute("emplist");
       List<Employe>list = (List<Employe>)obj;  
     %>
     <table border="1" cellspacing="0" cellpadding="0" height="400" align="center">
     <tr>
     <caption> All Student List</caption>
     <tr>
     <th>name</th>
     <th>PHOTO</th>
     </tr>
     <tr>
     <td>
     <img alt="not founf" src="imagec?stu_name=<>" style="height:200px; weidth:200">
     </td>
     </tr>
     
     </table>
      
    
</body>
</html>