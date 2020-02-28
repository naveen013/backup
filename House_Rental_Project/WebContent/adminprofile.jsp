<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}
</style>
</head>
<body bgcolor="#E6E6FA">

<h2>Responsive "Meet The Team" Section</h2>
<h1>Admins Profiles</h1>
<br>

<div class="row">
  <div class="column">
    <div class="card">
      <img src="image/vishal1.jpg" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Vishal Kumar</h2>
        <p class="title">CEO & Founder</p>
        <p></p>
        <p>vishalpv116@gmail.com</p>
        <p><button class="button">Contact-987976868</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="image/monika.jpg" alt="Mike" style="width:100%">
      <div class="container">
        <h2>Monika Hammad</h2>
        <p class="title">Art Director</p>
        <p></p>
        <p>monika@gmail.com</p>
        <p><button class="button">Contact-9554634267</button></p>
      </div>
    </div>
  </div>
  
  
  <div class="row">
  <div class="column">
    <div class="card">
      <img src="image/naveen.jpg" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Naveen Pandey</h2>
        <p class="title">Software Devloper</p>
        <p></p>
      	   <p>naveenjma054@gmail.com</p>
        <p><button class="button">Contact-8889065045</button></p>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="image/ankit.jpg" alt="John" style="width:100%">
      <div class="container">
        <h2>Ankit Raghuvansi</h2>
        <p class="title">Designer</p>
        <p></p>
        <p>ankitnitrr@gmail.com</p>
        <p><button class="button">Contact-8986776855</button></p>
      </div>
    </div>
  </div>
</div>


</body></html>