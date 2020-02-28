<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
*{
	 margin: 0px;
	 padding: 0px;
 }
#div1{
    width:100%;
    height:1000px;
    background-color:pink;
}
.leftmenu{
	width: 25%;
	line-height: 80px;
	float: left;
}
.rightmenu{
	width: 75%;
	height: 100px;
	float: right;
}
.rightmenu ul{
	margin-left: 250px;
}
#div2{
   width:100%;
   height: 150px;
   background-color: skyblue;
}
#div3{
    width:100%;
    height:600px;
    background-color: white;
    list-style: none;
}
#div3 ul li{
	   background-color: black;
	   width:150px;
	   border:1px solid white;
	   height:50px;
	   line-height: 50px;
	   text-align: center;
	   float: left;
	   color: white;
	   font-size: 18px;
	 }
</style>
</head>
<body>
  <div id="div1">
       <div id="div2">
      <div id="leftmenu"> 
       <h1>STUDENTMANAGENT</h1>
       </div>
       <div id="rightmenu">
       <ul>
       <li>Login</li>
       </ul>
       </div>
       </div>
   <div id="div3">
      <ul>
         <li style="width: 170px"> <a href="showstudent">View_Student</a>&nbsp;&nbsp;&nbsp;</li>
       </ul>
       <ul>
        <li style="width: 170px"><a href="stu_form.jsp">ADD Student</a>&nbsp;&nbsp;&nbsp;</li>
        </ul>
        
        <ul>
       <li style="width: 170px"> <a href="stu_search_form.jsp">Search Stu By Name</a>&nbsp;&nbsp;&nbsp;</li>
        </ul>
        <ul>
       <li style="width: 180px"> <a href="search_form.jsp">Search Stu By Roll No</a>&nbsp;&nbsp;&nbsp;</li>
       </ul>
       <ul>
       <li style="width: 170px"> <a href="showbranch">View_Branch</a>&nbsp;&nbsp;&nbsp;</li>
        </ul>  
        <ul>
        <li style="width: 170px"><a href="Add_Branch_form.jsp">Add_Branch</a>&nbsp;&nbsp;&nbsp;</li>
        </ul>
        <ul>
        <li style="width: 170px"><a href="branchsearch_form.jsp">Search Branch By Id</a>&nbsp;&nbsp;&nbsp;</li>
        </ul>
  </div>
</div>
</body>
</html>