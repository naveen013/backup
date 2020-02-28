<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@include file="Header.jsp" %>
<%@page import="stu.hub.util.MyDbUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<% String subject = request.getParameter("btype");%>
<% String name = request.getParameter("bname");
int bookstatus = 1;
String subtopic = request.getParameter("spe");
String author = request.getParameter("author");%>
<% Connection conn = null;
PreparedStatement pstat = null;
ResultSet rs = null;
RequestDispatcher rd = null;%>
<% try {%>
	<%conn = MyDbUtil.getConnection();
	String sql = "SELECT * FROM BOOK_STORE WHERE BOOK_NAME=?"
				+" OR SUBJECT=? OR AUTHOR=? OR SUBTOPIC=?";
	pstat = conn.prepareStatement(sql);
	pstat.setString(1, name);
	pstat.setString(2, subject);
	pstat.setString(3, author);
	pstat.setString(4, subtopic);
	rs = pstat.executeQuery(); %>
	<center>
	<h3>Books will be provided on first come first get policy.</h3>
	<h3>Books Related To Your Search:</h3><br>
	<table border='2' style="background-color:lightgray;">
	<tr ><th colspan="2">Subject</th><th colspan="2">TOPIC</th>
	<th colspan="2">BOOK_NAME</th><th colspan="2">Author</th>
	</tr>
	<%while(rs.next()){
		String s = rs.getString("STATUS");
		if(s.equalsIgnoreCase("AVAILABLE")){
		bookstatus = 0;%>
		<tr><td colspan="2"><%= rs.getString("SUBJECT")%></td>
		<td colspan="2"><%=rs.getString("SUBTOPIC") %></td>
		<td colspan="2"><%=rs.getString("BOOK_NAME") %></td>
		<td colspan="2"><%=rs.getString("AUTHOR") %></td>
		<%}%>
		</tr>
	
	<%}%>
	</table>
	</center>
	<%if(bookstatus==1){ %>
	<center>
	<h3>Sorry,The book is currently unavilable.<br>
	Please try later.</h3>
	<%String s = "SELECT * FROM BOOK_DEMAND WHERE BOOK_NAME=? AND AUTHOR=?";
		pstat = conn.prepareStatement(s);
			pstat.setString(1,name);
			pstat.setString(2,author);
			rs = pstat.executeQuery();
			if(rs.next()){
				int demand = rs.getInt("DEMAND");
				int dn = rs.getInt("DN");
				demand++;
				String s2 = "UPDATE BOOK_DEMAND SET DEMAND=? WHERE DN=?";
				pstat = conn.prepareStatement(s2);
				pstat.setInt(1,demand);
				pstat.setInt(2,dn);
				int st = pstat.executeUpdate();
				if(st==1){
					System.out.println("Demand incresed for book");
				}
			}else{
				String s3 = "INSERT INTO BOOK_DEMAND VALUES"
			+"((SELECT NVL(MAX(DN),0)+1 FROM BOOK_DEMAND),?,?,?)";
				pstat = conn.prepareStatement(s3);
				pstat.setString(1,name);
				pstat.setString(2,author);
				pstat.setInt(3,1);
				int st = pstat.executeUpdate();
				if(st==1){
					System.out.println("New entry for book");
				}
			}
	
	%>
	</center>
	<%} %>
			
	<%}catch (Exception e) {
			// TODO: handle exception
	}%>
	<div id="project_footer" style="margin-top:500px;">
		&copy: www.studenthub.com
	</div>
</body>

</html>