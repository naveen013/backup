<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

   <fieldset style="width:270px;"><legend align="center"><b>Branch information form</b></legend>
   <form action="add_branch" align="center" height=30% width=40%>
      BranchId:&nbsp;&nbsp;&nbsp;<input type="number" name="BranchId" min=1001 max=1o14><br>
      BranchName:&nbsp;&nbsp;&nbsp;;<input type="text" name="BranchName"><br>
      Hod:&nbsp;&nbsp;&nbsp;<input type="text" name="Hod"><br>
           <input type="submit" value="Add_Branch">  <br>
           <input type = "reset">
   </form>
   </fieldset>
   <a href="home.jsp">Back_To_Home</a>

</body>
</html>