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
<%if(u!=null){ %>
<div id="project_main">
		<center>
			<div class="main_tagline">
	</div>
	<fieldset style="margin-right:-1038px; width:20%;border:none;">
	<h3><a href="searchlapreq.jsp">Know Your Request Status</a></h3>
	</fieldset>
		<fieldset style="width:70%;background-color: #45d4de;"><legend style="font-size: 20px">Detail</legend>
			<form action="LaptopReqController" method="post">
				<table width="100%">
					<tr>
					<th style="font-size: 20px">Quantity</th>
					<td colspan="2">
					<select name="qnty" class="btn">
					<option value="1" selected >1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					</select></td>
					</tr>
					<center>
					<tr>
					<th style="font-size: 25px"> Laptop 1 Details:</th>
					</tr>
					</center>
					<tr>
						<th style="font-size:20px;">Brand/Model:</th><td><input type="text" name="model1" placeholder="Brand Name" class="input_style"></td>
						</tr><tr>
						<td style="font-size:20px;">Problem Type:
						<td style="font-size: 25px"><input type="checkbox" name="prob1" value="Hardware" > Hardware</td>
						<td style="font-size: 25px"><input type="checkbox" name="prob1" value="Software"> Software</td>
						<td style="font-size: 25px"><input type="checkbox" name="prob1" value="Other"> Other</td>
					</tr>
					
					<tr>
						<td colspan="1" style="font-size: 20px">Problem Description</td>
						<td colspan="2"><textarea  rows="2" cols="20"  name="desc1" placeholder="Problem Description Here" class="input_style"></textarea></td>
					</tr>
					<tr>
					<th style="font-size: 20px"> Laptop 2 Details: *Optional</th>
					</tr>
					<tr>
						<th style="font-size:20px;">Brand/Model:</th><td><input type="text" name="model2" placeholder="Brand Name" class="input_style"></td>
						</tr><tr>
						<td style="font-size:20px;">Problem Type:
						<td style="font-size: 25px"><input type="checkbox" name="prob2" value="Hardware" > Hardware</td>
						<td style="font-size: 25px"><input type="checkbox" name="prob2" value="Software"> Software</td>
						<td style="font-size: 25px"><input type="checkbox" name="prob2" value="Other"> Other</td>
					</tr>
					
					<tr>
						<td colspan="1" style="font-size: 20px">Problem Description</td>
						<td colspan="2"><textarea  rows="2" cols="20"  name="desc2" placeholder="Problem Description Here" class="input_style"></textarea></td>
					</tr>
					
					
					
					
						<td></td>

				</table>
					<input type="submit" value="Submit Request">
				</form>

			</fieldset>
		</center>


	</div>
<%}else{ %>
<br>
<center>
<h1>Please Login First</h1>
<hr>
<h1>
<a href="login.jsp" style="text-decoration:none;color:green;">Login</a>
</h1>
</center>
<%} %>

		








</body>
</html>