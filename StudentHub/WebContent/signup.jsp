<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function greet(){
	alert("Send OTP to your email-id...");
}
</script>
<%!
String val="";
%>

<%
out.print(val);
/*String sid="";*/
String name="";
String login_id="";
String gender="";
String email="";
String password="";
String contactNo="";
String address="";
String institute="";
String course="";
int yearOfAdmission=2014;
String message="RequestOTP";
Object obj=null;
User newUser=null;
obj=request.getAttribute("signupuser");
 
if(obj!=null){
	message = "ResendOTP";
	newUser = (User)obj;
	name = newUser.getName();
	gender = newUser.getGender();
	login_id = newUser.getLogin_id();
	contactNo = newUser.getContactNo();
	email = newUser.getEmail();
	address=newUser.getAddress();
	institute=newUser.getInstitute();
	course=newUser.getCourse();
	password=newUser.getPassword();
	yearOfAdmission = newUser.getYearOfAdmission();
}

%>

<%
String ref="";
Object ob2 = request.getAttribute("formfield");
if(ob2!=null){
	ref=(String)ob2;
}
%>

<h3 style="background-color:black;color:white;width:20%; text-align:center"><%=ref%></h3>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="project_main">
		<br>
		<center>
		<fieldset style="width:60%;background-color: #45d4de;"><legend style="font-size: 20px">Sign Up</legend>
<form action="OtpSignupController" name="signupform" method="post">
				<table width="100%">
					<tr>
						<td>NAME:<br><input type="text" name="name" value="<%=name %>"placeholder="ENTER FULL Name" class="input_style" ></td>
						
					</tr>
					<%if(gender.equals("male")){ %>
					<tr>
					
						<td>GENDER:<br><input type="radio" name="gender" value="male" checked="checked">Male</td>
						<td><input type="radio" name="gender" value="female"> Female</td>
						<td><input type="radio" name="gender" value="other" > Other</td>
					</tr>
					<%} else if(gender.equals("female")){%>
					<tr>
					
						<td>GENDER:<br><input type="radio" name="gender" value="male">Male</td>
						<td><input type="radio" name="gender" value="female" checked="checked"> Female</td>
						<td><input type="radio" name="gender" value="other" > Other</td>
					</tr>
					<%} else if(gender.equals("other")){%>
					<tr>
					
						<td>GENDER:<br><input type="radio" name="gender" value="male">Male</td>
						<td><input type="radio" name="gender" value="female" > Female</td>
						<td><input type="radio" name="gender" value="other" checked="checked" > Other</td>
					</tr>				
					<%}else{ %>
					<tr>
						<td>GENDER:<br><input type="radio" name="gender" value="male">Male</td>
						<td><input type="radio" name="gender" value="female"> Female</td>
						<td><input type="radio" name="gender" value="other" > Other</td>
					</tr>
					<%} %>
					<tr>
						<td>Mobile:<br><input type="text" name="mobile" value="<%=contactNo%>" maxlength="12" placeholder="Enter Mobile" class="input_style"></td>
						<td colspan="2">Email:<br><input type="Email" value="<%=email %>" name="email" placeholder="Enter Email" class="input_style"></td>
					</tr>
				<tr>
						<td colspan="2"><textarea  rows="2" cols="40" name="addr" placeholder="Address" class="input_style"><%=address %></textarea> </td>
					</tr>
					<tr>
						<td colspan="2">User_ID:<br><input type="text" name="login_id" value="<%=login_id %>" placeholder="Select a User Name" class="input_style"> </td>
					</tr>
					
					<tr>
					<td colspan="2">Institute:<br><input type="text" name="institute" value="<%=institute %>" placeholder="Institute Name" class="input_style"></td>
					
					</tr>
					<tr>
					<td colspan="2">Course:<br><input type="text" name="course" value="<%=course %>" placeholder="Course of study" class="input_style"></td>
					</tr>
					<tr>
					<td colspan="2">Year Of Admission:<br><input type="text" name="year" value="<%=yearOfAdmission %>" placeholder="Admission_Year"></td>
					</tr>
					<tr>
						<td colspan="2">Password:<br><input name="password" type="password" value="<%=password %>" placeholder="Choose Your Password" class="input_style"> </td>
					</tr>
				
					<tr>
					<td colspan="2">OTP:<br><input type="password" name="OTP">
					<button name="button" onclick="greet()" value="1">
					<%=message %></button>
					</td>
					</tr>
						<tr>
						<td colspan="2">Confirm Password:<br><input type="password" name="c_pass" placeholder="Confirm Password" class="input_style"> </td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="reset" value="Reset"></td>
						<td align="right"><input type="submit" name="button" value="sign up"></td>
					</tr>
				</table>
			</form>
		</fieldset>
		</center>
	<br>
	<div id="project_footer">
		&copy: www.studenthub
	</div>
	</div>
</body>
</html>