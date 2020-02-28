<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<style type="text/css">
   form{
        background:skyblue;
   }
   fieldset{
     background: skyblue;
   }

</style>
<title>Insert title here</title>
</head>
<body bgcolor="lightpink">
         <fieldset style="width:270px;"><legend align="center"><b>Add New Student</b></legend>
   <form action="add_stu" align="center" height=30% width=40%>
      ID:&nbsp;&nbsp;&nbsp;<input type="number" name="id" min=10 max=100><br>
         First Name:&nbsp;&nbsp;&nbsp;;<input type="text" name="first_name"><br>
Last Name:&nbsp;&nbsp;&nbsp;<input type="text" name="last_name"><br>
     Sex:&nbsp;&nbsp;&nbsp;     
  <input type="radio" name="sex" value="male"> Male
  <input type="radio" name="sex" value="female"> Female<br>
       Birth Date:&nbsp;&nbsp;&nbsp;<input type="date" name="birthdate"><br>
       Phone:&nbsp;&nbsp;&nbsp;<input type="number" name="phone"><br>
        Address:&nbsp;&nbsp;&nbsp;<input type="text" name="Address"> <br>
           <input type="submit" value="Add">  <br>
           <input type = "Cancel">
           
   </form>
   </fieldset>
</body>
</html>