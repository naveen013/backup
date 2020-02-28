<%@ include file="Header.jsp" %>
<%@page import="stu.hub.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%//if(u!=null){// %>
<div id="project_main">
		<center>
			<div class="main_tagline">
	</div>
		<fieldset style="width:70%;background-color: #45d4de;"><legend></legend>
			<form action="LaptopSellController" method="post">
				<table width="100%">
				<center><tr><th style="font-size:25px;">
				Sell Your Laptop:</th></tr></center>
					<tr>
					<th style="font-size:20px;">Full Name:</th>
					<td><input type="text" name="owner" placeholder="Your Name"></td>
					</tr>
					<tr>
					<th style="font-size:20px;">Contact No:</th>
					<td><input type="text" name="contact" placeholder="Mobile"></td>
					</tr>
					<tr></tr>
					<tr>
					<center>
					<th style="font-size: 20px;">Laptop Details:</th>
					</center>
					</tr>
					<tr></tr>
					<tr>
						<th style="font-size:20px;">Brand/Model:</th>
						<td><input type="text" name="brand" placeholder="Brand Name" class="input_style"></td>
					</tr>
						<tr>
						<th style="font-size:20px;">RAM:</th>
						<td><input type="text" name="RAM" placeholder="RAM Size" class="input_style"></td>
						</tr>
						<tr>
						<th style="font-size:20px;">HardDrive:</th>
						<td><input type="text" name="Hardware" placeholder="Disk space" class="input_style"></td>
						</tr>
						<tr>
						<th style="font-size:20px;">Processor:</th>
						<td><input type="text" name="processor" placeholder="Processor&generation" class="input_style"></td>
						</tr>
						<tr>
						<th style="font-size:20px;">Selling Price:</th>
						<td><input type="text" name="price1" placeholder="laptop price" class="input_style"></td>
						</tr>					
					<tr>
								
						<td></td>
						<td><input type="submit" value="Submit Request"></td>
					</tr>

				</table>
				</form>

			</fieldset>
		</center>


	</div>
<%//}else{ %>
<br>
<!--  <center>
<h1>Please Login First</h1>
<hr>
<h1>
<a href="login.jsp" style="text-decoration:none;color:green;">Login</a>
</h1>
</center>-->
<%//}// %>

	<div id="project_footer"></div>

</body>
</html>