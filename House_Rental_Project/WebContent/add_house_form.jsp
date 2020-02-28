<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="css/owner_regestration.css">
</head>
<body background="image/ret13.jpg">
            <div class="header">
        <h2>ADD HOUSE FORM</h2>
   </div>
   <form action="addhousecontroler" enctype="multipart/form-data" method="post">
       <div class="input-group">
       	   <label>name</label>
	   <input type="text"name="name">
	   </div>
	   <div class="input-group">
	   <label>Location</label>
	   <input type="text"name="location">
	   </div>
	   <div class="input-group">
	   <label>Category</label>
	   <input type="text"name="category">
	   </div>
	   <div class="input-group">
	   <label>Bedroom</label>
	   <input type="number"name="bedroom">
	   </div>
	   <div class="input-group">
	   <label>Email</label>
	   <input type="email"name="email">
	   </div>
	   <div class="input-group">
	   <label>Mobile</label>
       <input type="number" name="mobile"> 
	   </div>
	   	<div class="input-group">
	   <label>image_name</label>
	   <input type="txt"name="img_name">
	   </div>
	   <div class="input-group">
	   <label>Photo</label>
	   <input type="file" name="photo" size="50"/>
	   </div>
	   <div class="input-group">
	    <button type="submit" name="Add" class="btn">Add</button>
	   </div>
   
   </form>
</body>
</html>