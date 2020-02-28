<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
      <style>
     #div1{
	     width: 100%;
		 height:100px;
		 border: 6px double yellow;
		 background: pink;
		 margin: 10px auto;
	 }
	 #div2{
	    background: silver;
		width: 100%;
		height: 1500px;
        border: 6px double blue;
		margin: 15px auto 0; 
	 }
	 #div3{
	      width: 20%;
		 height:100px;
		 border: 6px double yellow;
		 background: pink;
		 margin: 30px auto;
	 }
	 	 *{
	 margin: 0px;
	 padding: 0px;
	 }
	 #container ul{
	 list-style: none;
	 }
	 #container ul li{
	   background-color: skyblue;
	   width:150px;
	   border:1px solid white;
	   height:50px;
	   line-height: 50px;
	   text-align: center;
	   float: left;
	   color: white;
	   font-size: 18px;
	 }
	 #container ul li:HOVER {
	  background-color: #388222;  
  }
  #container ul ul{
  display: none;
  }
   #container ul li:HOVER > ul{
    display: block;
    
   }
	</style> 
</head>
<body>
   <a href="LoginForm.jsp">LoginForm</a>
   <div id="div1">
   <div id="container">
   <ul>
         <li style="width: 200px">STUDENT
                   <ul>
                       <li style="width: 200px"><a href="Stu_form.jsp">Add_Student</a></li>
                        <li style="width: 200px"><a href="student">Manage Student</a></li>
                       
                   </ul>
               </li>
    </ul>  
    </div>         
   </div>
   <div id="div2">
           <div id="div3"><li style="width: 220px"></li></div>
           
   </div>
   

</body>
</html>