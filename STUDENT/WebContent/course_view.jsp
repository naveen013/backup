<%@page import="nit.com.bo.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
     <%
       Object obj = request.getAttribute("courselist");
       List<Course>list = (List<Course>)obj;
     %>
     Total course = <%=list.size() %>
     <table border="1" bgcolor="pink" align="center">
     <caption><b>Course List:</b></caption>
     <tr>
     <th>CourseId</th>
     <th>Course Name</th>
     <th>Available Seat</th>
     <th>Duration</th>
     <th>Eligibility</th>
     <th>Subject</th>
      <th>Admission Mode</th>
       <th>Course Type</th>
       <th>Study Mode</th>
     </tr>
     <%for(Course course:list) {%>
        <tr>
        <td><%=course.getCourseId() %></td>
        <td><%=course.getCourseName() %></td>
        <td><%=course.getNoOfSeat() %></td>
        <td><%=course.getDuration() %></td>
        <td><%=course.getEligibility()%></td>
        <td><%=course.getSubjName() %></td>
        <td><%=course.getAdmMode() %></td>
         <td><%=course.getCourseType() %></td>
        <td><%=course.getStudyMode() %></td>
   <td>
      <%} %>
     </table>

</body>
</html>