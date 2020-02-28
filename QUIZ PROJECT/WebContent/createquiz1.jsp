
<%@page import="java.awt.Dialog"%><jsp:include page="header.jsp"></jsp:include>

<%
String islogin=(String)session.getAttribute("islogin");
if(islogin==null){
request.setAttribute("notlogin_msg","Sorry,Please do Login first");

%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>

             <% 
					if(request.getAttribute("notlogin_msg")!=null){
					out.print("<font size='2' color='red' m>");
					out.print(request.getAttribute("notlogin_msg"));
					out.print("</font>");
					}
					%>
				<% 
					if(request.getAttribute("Error")!=null){
					out.print("<font size='2' color='red' >");
					out.print(request.getAttribute("Error"));
					out.print("</font>");
					}
					%>
					 <% 
					 	if(request.getAttribute("counter")!=null){
                   Integer i=(Integer)request.getAttribute("counter");
                  		 if(i==10){
   								request.setAttribute("finished","quiz successfully submitted");
   			
   					%>
   				          <jsp:forward page="home.jsp"></jsp:forward>
   							          <% 
   							             
                   }}
                  %>
                  <div class="left_content">
                  
            	<div class="calendar_box2">
            	
                	<div class="calendar_box_content">
               
                		<h1>Welcome to my Site</h1>
                		                   		<marquee direction="left" style="color: navy;" onmouseover="stop()" onmouseout="start()"><B>Assess Yourself by taking quizs on various sunject</B></marquee>
                		   
                		<form method="post" action="saveques.jsp" >
					<table>
					<tr><td>questionId:</td><td><input type="number" name="quid" /></td></tr>	
					<tr><td>Question:</td><td><textarea rows="3" cols="" name="question" ></textarea></td></tr>
					<tr><td>Option1:</td><td><input type="text" name="option1" /></td></tr>	
					<tr><td>Option2:</td><td><input type="text" name="option2" /></td></tr>
					<tr><td>Option3:</td><td><input type="text" name="option3" /></td></tr>
					<tr><td>Option4:</td><td><input type="text" name="option4" /></td></tr>
					<tr><td>Answer:</td><td><input type="text" name="answer" /></td></tr>	
					<tr><td>QuizName:</td><td><input type="text" name="quizname" /></td></tr>	
					<tr><td>Description:</td><td><input type="text" name="description" /></td></tr>			
                    <tr><td></td><td><input type="submit" value="Next"></td></tr>
                    </table>
                     </form>
                	</div>
                </div>
                <div class="news_left">
            
                	<div class="">
                    	<div class=""></div>
                        <div class="">
						<span></span>
				
                        <a href="" class=""></a>                        
                        </div>
                    </div>
                    <br>
                	<div class="">
                    	<div class=""></div>
                        <div class="">
						
                        <a href="" class=""></a>                        
                        </div>
                    </div>                    
                    
                    
                    
                
                </div>
            
            
            </div>
            <!--end of left content-->


            <div class="">
            
                
                <div class="project_box">
                    <a href="#"><img src="" alt="" title="" class="left_img" border="0"></a>
                    
                </div>

                <div class="project_box">
                    <a href="#"><img src="" alt="" title="" class="left_img" border="0"></a>
                   
                </div>
                <br>
                <div>
                         
 </div>                   
                  <div class="">
                   
                </div>
                
                 <div class="">
                    <ul>                        
                    </ul>
                </div>  
                   
            
            </div><!--end of right content-->


	<div id="footer">
    
    </div>


		</div> <!--end of center box-->
	</div> <!--end of main content-->
</div> <!--end of main container-->
</body></html>

