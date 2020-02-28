<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%--<%@page import="com.sun.org.apache.bcel.internal.generic.Select"--%>
<%! static int count=0; %>
<%! static int count1=0; %>



<%
String name=(String)session.getAttribute("quizname");
System.out.println(name);
try{


Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
/*if(count==0){
//PreparedStatement ps1= con.prepareStatement("select min(qid) from quizques where quizname='"+name+"'");
//PreparedStatement ps2= con.prepareStatement("select max(qid) from quizques where quizname='"+name+"'");
//ResultSet rs1= ps1.executeQuery();
//ResultSet rs2=ps2.executeQuery();
//if(rs2.next()){
//count1=rs2.getInt(1);
//session.setAttribute("max",count1);
//}
/*if(rs1.next()){
count=rs1.getInt(1);
session.setAttribute("min",count);

}
}*/
double rand=Math.random()*10+1;
int val=(int)rand;
String name1="javaquiz";
PreparedStatement ps=con.prepareStatement("select * from quizques where qid='"+val+"'");
ResultSet rs=ps.executeQuery();
if(rs.next()){
int no=rs.getInt(1);
String question=rs.getString(2);
String option1= rs.getString(3);
String option2= rs.getString(4);
String option3= rs.getString(5);
String option4= rs.getString(6);
session.setAttribute("question",question);
session.setAttribute("option1",option1);
session.setAttribute("option2",option2);
session.setAttribute("option3",option3);
session.setAttribute("option4",option4);
}

System.out.print(count);
count++;
session.setAttribute("count",count);
if(count>(Integer)session.getAttribute("max")){
count=0;
session.setAttribute("ans",null);
}
con.close();

}catch(Exception e){e.printStackTrace();}
//end of if
%>
<jsp:forward page="start.jsp"></jsp:forward>