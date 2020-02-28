<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
  <style>
 *{
   margin: 0px;
   padding: 0px;
 }
     #div1{
	     width: 100%;
		 height:100px;
		 border: 6px double blue;
		 background: orange;
		 margin: 10px auto;
	 }
	 #div2{
	    background: silver;
		width: 100%;
		height: 300px;
		border: 6px double blue;
		margin: 15px auto 0; 
	 }
	 #div3{
	    background: red;
		width: 100%;
		height: 300px;
		margin: 15px auto 0; 
		border: 6px double blue;
	 }
	 *{
	 margin: 0px;
	 padding: 0px;
	 }
	 #container ul{
	 list-style: none;
	 }
	 #container ul li{
	   background-color: #3c3E94;
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
   #name{
   float:center;
   padding:0px;
   	margin-bottom:10px;
   	text-align: center;
   }
   	 #banner{
	        width: 950;
			height: 300px;
	 }
	 #banner img {
	        width: 1350px;
			height: 280px;
	 }
	 
  </style>
</head>
<body>
  <div id="div1">
     <img src="photo/apsulogo.jpg.png" width="50px"/>
     <font size=10 color="red"><h5 id="name">Awadesh Pratap Singh, University</h5></font>
     </div>
     <div id="container">
           <ul>
               <li style="width: 220px">About Us
                   <ul>
                      <li style="width: 220px"><a href="about.jsp">About APS University,Rewa</a></li>
                      <li style="width: 220px"><a href="vision.jsp">Mission & Vision</a></li>
                      <li style="width: 220px"><a href="AboutRewa.jsp">About Rewa City</a></li>
                      <li style="width: 220px"><a href="climate.jsp">Climates Of Rewa City</a></li>
                      <li style="width: 220px"><a href="aproch.jsp">How to Approch the Rewa city</a></li>
                      <li style="width: 220px"><a href="places.jsp">Place Of Interset Rewa</a></li>
                   </ul>
               </li>
               <li>Board Committees
                  <ul>
                       <li>Ec Members</li>
                       <li>Academic Council</li>
                       <li>Board Of Studies</li>
                       <li>Evaluation Board</li>
                  </ul>
               </li>
               <li>Administration
                <ul>
                  <li style="width: 260px">Chanceller</li>
                  <li style="width: 260px">Vice Chanceller</li>
                  <li style="width: 260px">Rector</li>
                  <li style="width: 260px">Registrar</li>
                  <li style="width: 260px">Dean & Director</li>
                  <li style="width: 260px">Dean Student Welfare</li>
                  <li style="width: 260px">Dean College Devlopment Council</li>
                  <li style="width: 260px">Admn Office</li>
                </ul>
               </li>
               <li>Course
                 <ul>
                 <li style="width: 220px">Regular Courses<a href="viewcourse">View_Course</a></li>
                 <li style="width: 220px">Correspondance Course</li>
                 <li style="width: 220px">Self Supporting Course</li>
                 </ul>
               </li>
               <li>Affilited College
               <ul>
                 <li style="width: 220px">Government College</li>
                <li style="width: 220px">Aided College</li>
                <li style="width: 220px">Private College</li>
                <li style="width: 220px">College Releted Information</li>
               </ul>
               </li>
               <li>Department</li>
               <li>Admission
               <ul>
               <li>Admission Process</li>
               <li>Admission Notice</li>  
               </ul>
               </li>
               <li>Facilities
               <ul>
                  <li>Centeral Library</li>
                  <li>Computer Center</li>
                  <li>Guest House</li>
                  <li>Stadium</li>
               </ul>
               </li>
           </ul>
    </div> 

   	<div id="div2">
   	
   	</div>

<div id="div3">     
 <center>    
  <a href="showstudent">View_Student</a>&nbsp;&nbsp;&nbsp;
  <a href="Stu_form.jsp">ADD Student</a>&nbsp;&nbsp;&nbsp;
  <a href="stu_search_form.jsp">Search Student By Name</a>&nbsp;&nbsp;&nbsp;
  <a href="search_form.jsp">Search Student By Roll No</a>&nbsp;&nbsp;&nbsp;
  </center>
      <a href="showbranch">View_Branch</a>&nbsp;&nbsp;&nbsp;  
  <a href="Add_Branch_form.jsp">Add_Branch</a>&nbsp;&nbsp;&nbsp;
  <a href="branchsearch_form.jsp">Search Branch By BranchId</a>&nbsp;&nbsp;&nbsp;
</div>  

</body>
</html>