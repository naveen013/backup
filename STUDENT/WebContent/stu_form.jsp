<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

   <fieldset style="width:270px;"><legend align="center"><b>Student information form</b></legend>
   <form action="add_stu" align="center" height=30% width=40% >
      Roll_No:&nbsp;&nbsp;&nbsp;<input type="number" name="stu_Rollno" min=17223001 max=17223084><br>
         Name:&nbsp;&nbsp;&nbsp;;<input type="text" name="stu_Name"><br>
Enrollment_No:&nbsp;&nbsp;&nbsp;<input type="text" name="stu_enrollment"><br>
     Semester:&nbsp;&nbsp;&nbsp;<input type="number" name="sem" min=1 max=6><br>
       Course:&nbsp;&nbsp;&nbsp;<input type="text" name="course"><br>
       Branch:&nbsp;&nbsp;&nbsp;<input type="text" name="branch"><br>
        Email:&nbsp;&nbsp;&nbsp;<input type="email" name="stu_Email"> <br>
           <input type="submit" value="add_Stu">  <br>
           <input type = "reset">
           
   </form>
   </fieldset>

</body>
</html>