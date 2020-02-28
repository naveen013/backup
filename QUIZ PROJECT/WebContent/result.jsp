<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<html>


<jsp:include page="header.jsp"></jsp:include>

<%
String islogin=(String)session.getAttribute("islogin");
if(islogin==null){
request.setAttribute("notlogin_msg","Sorry,Please do Login first");

%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>



<div class="left_content">
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
					if(request.getAttribute("finished")!=null){
					   out.print("<font size='2' color='navy'>");
                   out.print("<B>");
					out.print(request.getAttribute("finished"));
					  out.print("<B>");
   						out.print("</font>");
					}
				
					%>
            	<div class="calendar_box">
            	
                	<div class="calendar_box_content">
               
                		<h1>Welcome to my Site</h1>
                		              		<marquee direction="left" style="color: navy;" onmouseover="stop()" onmouseout="start()"><B>Assess Yourself by taking quizs on various subjects</B></marquee>
                	<form action="view.jsp">
                	<p>
                	<font style="color: navy;"><B>Your <%=request.getAttribute("total") %> questions are correct</B></font><BR/>
                	<input type="submit" value="view description">            
                	</p>
					</form>
				
					

                     
                	</div>
                </div>
                
                <div class="news_left">
                
                	<div class="news_box">
                    	<div class="calendar">1</div>
                        <div class="news_content">
						                      
                        </div>
                    </div>
                    <br>
                	<div class="news_box">
                    	<div class="calendar">2</div>
                        <div class="news_content">
						<p><span></span>
						</p>
                        <a href="" class=""></a>                        
                        </div>
                    </div>                    
                    
                    
                    
                
                </div>
            
            
            </div>
            <!--end of left content-->


            <div class="right_content">
         
                
                <div class="project_box">
                    <a href="#"><img src="images/p1.gif" alt="" title="" class="left_img" border="0"></a>
                </div>

                <div class="project_box">
                    <a href="#"><img src="images/p2.gif" alt="" title="" class="left_img" border="0"></a>
                    
                </div>
                <br>
                <div>
                
              <h1 ><br></h1>          
 </div>                   
                  <div class="services">
                  
                </div>
                
                 <div class="services">
                    <
                </div>  
                   
            
            </div><!--end of right content-->


	<div id="footer">
    
    </div>


		</div> <!--end of center box-->
	</div> <!--end of main content-->
</div> <!--end of main container-->
</body></html>

