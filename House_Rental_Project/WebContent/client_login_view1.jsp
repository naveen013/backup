<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>
<link href="css/style1.css" rel="stylesheet" type="text/css">
</head>
<body>  
 <div id="header">
 <div id="logo1"><img src="image/clogo.jpg" width="100%" height="140px" /></div>
  <div id="logo"><img src="image/logo2.png" width="100%" height="140px" /></div>
			<h1 style="color:#E6E6FA; padding-top: 40px; padding-left: 40px;">Room Rental</h1>
  </div>
     <div id="container1" style="margin-right:0px; margin-left:0px;">
        <ul class="menu_icon" style="width:100%">
         <li style="width:25%">Home
           <ul>
               <a href="home.jsp"><li style="width: 100%">Home</li></a>
           </ul>
        </li>
        
        <li style="width:25%">Customer
           <ul>
               <a href="viewallcustomer"> <li style="width: 100%">View Customer</li></a>
               
                </ul>
        </li>
        
        <li style="width:25%">Owner
           <ul>
               <a href="viewowner"> <li style="width: 100%">View Owner</li></a>
           </ul>
        </li>               
        
           <li style="width:25%">Logout
           <ul>
                <a href="clientlogut"><li style="width: 100%">Logout</li></a>
           </ul>
        </li>    
     </ul>
	 </div> 			

	  <center>
   <meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
  overflow:hidden;	
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 18px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
</style>
</head>
<body>
<br><br><br><br>
<h2>NeW DooRs ArE WaTiNg FoR You </h2>
<p></p>

<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/2.jpg" style="width:70%">
  <div class="text"></div>
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/4.jpg" style="width:70%">
  <div class="text"></div>
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/rent12.jpg" style="width:70%">
  <div class="text"></div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

      
</div>
</div>
</center>
          
<center>Copyright @RoomOnline 2019 by Infastructure having 11200</center>			


</body>
</html>