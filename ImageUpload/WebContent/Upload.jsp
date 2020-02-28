<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<a href="view_image.jsp" >click here</a>
     <centre>
  <form method="post" action="uploadservlet" enctype="multipart/form-data">
  <table border="0">
  <tr>
    <td>Enter your name</td>
    <td><input type="text" name="name" size="50"/></td>
  </tr>
  
    <tr>
    <td>upolad your photo</td>
    <td><input type="file" name="photo" size="50"/></td>
  </tr>
  
    <tr>
    <td colspan="2">
        <input type="submit" value="send"/>
    </td>
  </tr>
  
  </table>
  </form>       
      </centre>
</body>
</html>