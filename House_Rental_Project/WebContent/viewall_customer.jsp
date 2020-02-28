<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="nit.com.bo.Customer"%>
<%@page import="nit.com.bo.House"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>
<body bgcolor="#F5F5DC">
           <h2><a href="client_login_view1.jsp">Back To Client View</a><br></h2>
            <%
        Object obj = request.getAttribute("customerlist");
       List<Customer>list = (List<Customer>)obj;
      
     %>
                <h3 align="center"></>Total customer= <%=list.size() %></h3>
<table border="1px" cellpadding="0" cellspacing="0px"  width="90%" align="center">
<tr height="50px" align="center">
<td width="200px">NAME</td>
<td width="200px">PASSWORD</td>
<td width="200px">EMAIL</td>
<td width="200px">MOBILE</td>
<td width="200px">GENDER</td>
<td width="200px">ADDRESS</td>
<td width="200px">PICTURE</td>
</tr>
<%
for(Customer cust:list){%>
<tr align="center">
<td><%=cust.getUsername()%></td>
<td><%=cust.getPassword()%></td>
<td><%=cust.getEmail()%></td>
<td><%=cust.getMobile()%></td>
<td><%=cust.getGender()%></td>
<td><%=cust.getAddress()%></td>
<td ><img src="customerimagedownloadcontroler?img_name=<%=cust.getUsername()%>" height="150px" width="200px" /></td>
</tr>
<%} %>
</table>

</body>
</html>
