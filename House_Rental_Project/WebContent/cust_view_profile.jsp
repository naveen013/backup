<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="nit.com.bo.Owner"%>
<%@page import="nit.com.bo.Customer"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>

<%
 Object obj = request.getAttribute("custlist");
Customer cust=null;
 if(obj!=null){
	cust=(Customer)obj;
 }
%>
</head>
<body background="image/cpro.jpg" text="black">

<div style="border:1px solid #000000; width:45%; margin-left:350px; background:#CCCCCC">
<table  cellspacing="0" cellpadding="0" height="400px"  align="center" >
<tr>
<td width="60%">USERNAME:<%=cust.getUsername()%></td>
<td rowspan="10" width="30%"><div style="border:1;  height:200px; width:100%; margin:0px; padding:0px; margin-top:-200px" >
<img src= "custimagedownload?img_name=<%=cust.getUsername()%>"   style="height:200px; font-size:22px;" width="100%" alt="Image not found"/>
</div>
</td>
</tr>
<tr>
<td>PASSWORD:<%=cust.getPassword() %></td>
</tr>
<tr>
<td>MOBILE:<%=cust.getMobile() %></td>
</tr>
<tr>
<td>Email-Id:<%=cust.getEmail() %></td>
</tr>
<tr>
<td>GENDER:<%=cust.getGender() %></td>
</tr>
<tr>
<td>Address:<%=cust.getAddress() %></td>
</tr>
<tr>
</tr>
</table>
</div>
</body>
</html>
