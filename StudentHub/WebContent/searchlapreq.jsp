<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="stu.hub.util.MyDbUtil"%>
<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%int id = u.getSid(); %>
</head>
<body style="background-color:;">
<f:view>


<%
Connection con = null;
PreparedStatement pstat = null;
ResultSet rs = null;
try{%>
<%
con = MyDbUtil.getConnection();
String sql = "SELECT * FROM LAP_DETAILS WHERE SID=?";
pstat = con.prepareStatement(sql);
pstat.setInt(1,id);
rs = pstat.executeQuery();
%>
<div style="background-color: #e2f0f5;
			height: 400px;
			width: 100%">
<center>
<br>
<h2>Laptop Request Summary</h2>
<table border="2">
<tr><th>REQNO</th><th>MODEL</th><th>REQ_STATUS</th></tr>
<%while(rs.next()){
	int req = rs.getInt("REQ_NO");
	String model = rs.getString("MODEL");
	String status = rs.getString("STATUS");%>
	<tr><td><%=req %></td>
	<td><%=model %></td>
	<td><%=status %></td>
	</tr>
	
	<%} %>
</table>
</center>

<%} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

finally {
	if(con!=null) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//if
}
%>

</f:view>
</div>
	<div id="project_footer">
		&copy: www.studenthub.com
	</div>
</body>
</html>