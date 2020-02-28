<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="nit.com.bo.Owner"%>
<%@page import="nit.com.bo.House"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body background="image/ownerprofile.jpg" text="black">
           <h2><a href="client_login_view1.jsp" style="color:yellow">Back To Client View</a><br></h2>
            <%
        Object obj = request.getAttribute("ownerlist");
        List<Owner>list = (List<Owner>)obj;
      
     %>
    <h3 align="center"></>Total Owner= <%=list.size() %></h3>
<table border="1px" cellpadding="0" cellspacing="0px"  width="90%" align="center">
<tr height="50px" align="center">
<td width="200px">USERID</td>
<td width="200px">USERNAME</td>
<td width="200px">PASSWORD</td>
<td width="200px">MOBILE</td>
<td width="200px">EMAIL</td>
<td width="200px">GENDER</td>
<td width="200px">ADDRESS</td>
<td width="200px">PICTURE</td>
</tr>
<%
for(Owner ow:list){%>
<tr align="center">
<td><%=ow.getId()%></td>
<td><%=ow.getUsername()%></td>
<td><%=ow.getPassword()%></td>
<td><%=ow.getMobile()%></td>
<td><%=ow.getEmail()%></td>
<td><%=ow.getGender()%></td>
<td><%=ow.getAddress()%></td>

<td ><img src="imagec?img_name=<%=ow.getUsername()%>" height="150px" width="200px" /></td>
<td>
 <a href="deleteowner?ownername=<%=ow.getUsername()%>">Delete</a></td>
</tr>
<%} %>
</table>

</body>
</html>
