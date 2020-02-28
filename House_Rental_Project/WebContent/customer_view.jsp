<%@page import="java.util.List"%>
<%@page import="nit.com.bo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body >
 
      <%
         Object obj = request.getAttribute("customerlist");
      List<Customer>list = (List<Customer>)obj;
      %>
           <h3 align="center">Tottal Owner = <%=list.size() %></h3>
      <table border="1" align="center" >     
     <caption> All Coustomer List</caption>
     <tr>
     <th>USERNAME</th>
     <th>PASSWORD</th>
     <th>MOBILE</th>
     <th>EMAIL</th>
     <th>GENDER</th>
     <th>ADDRESS</th>
     </tr>
     <%for(Customer customer :list) { %>
     <tr>
     <td><%=customer.getUsername()%></td>
     <td><%=customer.getPassword()%></td>
    <td><%=customer.getMobile() %></td>
    <td><%=customer.getEmail() %></td>
    <td><%=customer.getGender() %></td>
    <td><%=customer.getAddress() %></td>
      <td>
       <a href="#">View</a>
      <a href="">Update</a>
        <a href="">Delete</a>
   </tr>
     <%} %>
     </table>
</body>
</html>