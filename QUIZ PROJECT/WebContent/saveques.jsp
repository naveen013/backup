<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

<%! static int counter=0; %>
<%
counter++;
 try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
String questionId= request.getParameter("quid");
String question= request.getParameter("question");
String option1= request.getParameter("option1");
String option2= request.getParameter("option2");
String option3= request.getParameter("option3");
String option4= request.getParameter("option4");
String answer=request.getParameter("answer");
String Quizname=request.getParameter("quizname");
String description=request.getParameter("description");

long quid = Long.parseLong(questionId); 
PreparedStatement ps1=con.prepareStatement("select max(quizname) from quizinfo");
ResultSet rs=ps1.executeQuery();
while(rs.next()){
String quizname= rs.getString(1);

//System.out.print(quizname);

//PreparedStatement ps=con.prepareStatement("insert into quizques values("+"select nvl(max(qid),0) from quizques"+" ,?,?,?,?,?,?,?,?)");
PreparedStatement ps=con.prepareStatement("insert into quizques values(?,?,?,?,?,?,?,?,?)");
ps.setLong(1,quid);
ps.setString(2,question);
ps.setString(3,option1);
ps.setString(4,option2);
ps.setString(5,option3);
ps.setString(6,option4);
ps.setString(7,answer);
ps.setString(8,quizname);
ps.setString(9,description);
int s= ps.executeUpdate();


}

}
catch(Exception e){e.printStackTrace();}

%>
<% 
request.setAttribute("counter",counter);
%>
<jsp:forward page="createquiz1.jsp"></jsp:forward>
