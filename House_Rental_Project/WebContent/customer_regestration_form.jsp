<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
   <link rel="stylesheet" type="text/css" href="css/owner_regestration.css">
</head>
<body bgcolor="lightgray">
       <div class="header">
        <h2>Customer Registration</h2>
   </div>
   <form action="addcustomer" enctype="multipart/form-data" method="post">

	   <div class="input-group">
	   <label>Username</label>
	   <input type="text"name="username">
	   </div>
	   <div class="input-group">
	   <label>Password</label>
	   <input type="password"name="password">
	   </div>
	   <div class="input-group">
	   <label>Email</label>
	   <input type="email"name="email">
	   </div>
	   <div class="input-group">
	   <label>Mobile</label>
	   <input type="text"name="mobile">
	   </div>
    Gender:    <input type="radio" name="gender" value="male"> Male
           <input type="radio" name="gender" value="female"> Female       
	      <input type="radio" name="gender" value="other"> Other 

	   <div class="input-group">
	   	   <label>Address</label>
	   <input type="text"name="address">
	   </div>
	   	 <div class="input-group">
	   <label>image_name</label>
	   <input type="txt"name="img_name">
	   </div>
	   <div class="input-group">
	   <label>Photo</label>
	   <input type="file" name="photo" size="50"/>
	   </div><br>
	   <div class="input-group">
	    <button type="submit" name="register" class="btn" align="right">Register</button>
	   </div>
   
   </form>
       
</body>
</html>