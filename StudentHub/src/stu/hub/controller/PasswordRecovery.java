package stu.hub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.hub.mail.SendMail;
import stu.hub.pojo.User;
import stu.hub.util.MyDbUtil;

@WebServlet("/PasswordRecovery")
public class PasswordRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String OTP="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		String login_id = request.getParameter("log");
		String email = request.getParameter("mail");
		if(login_id.isEmpty()||email.isEmpty()) {
			request.setAttribute("empty", "Please fill the empty fields");
			rd = request.getRequestDispatcher("passrecovery.jsp");
			rd.forward(request, response);
		}
		User nw = new User(login_id,email);
		Random ran = new Random();
		for(int i=1;i<=6;i++) {
			int no = ran.nextInt(9);
			OTP = no+""+OTP;
		}
		boolean otpstatus = false;
		try {
			otpstatus = SendMail.sendotp(email,OTP);
		}catch (Exception e) {
			e.printStackTrace();
			pw.print("Please check your connection");
			// TODO: handle exception
		}
		if(otpstatus) {
			System.out.println("OTP Sent to Mail-id");
			rd = request.getRequestDispatcher("passrecovery.jsp");
			request.setAttribute("nw", nw);
			rd.forward(request, response);
		}
		
	}//doGet
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = (String)request.getParameter("button");
		button = button+"0";
		if(button.equals("10")) {
					OTP="";
					doGet(request,response);
		}
		else {
			
			RequestDispatcher rd = null;
			String email = request.getParameter("mail");
			String login_id = request.getParameter("log");
			String otp = request.getParameter("sentotp");
			String npass = request.getParameter("newpass");
			String cpass = request.getParameter("cnfpass");
			
			if(email.isEmpty()||login_id.isEmpty()||otp.isEmpty()
					||npass.isEmpty()||cpass.isEmpty()) {
				request.setAttribute("error", "Please fill all fields");
				rd = request.getRequestDispatcher("passrecovery.jsp");
				rd.forward(request, response);
			}	
			if(!npass.equals(cpass)) {
				request.setAttribute("error", "New & Confirm Password should be same");
				rd = request.getRequestDispatcher("passrecovery.jsp");
				rd.forward(request, response);
			}
			
			if(otp.equals(OTP)) {
				Connection con = null;
				ResultSet rs = null;
				PreparedStatement pstat = null;
				try {
					con = MyDbUtil.getConnection();
					String sql="UPDATE SH_USER SET PASSWORD=? WHERE LOGIN_ID=? AND EMAIL_ID=?";
					pstat = con.prepareStatement(sql);
					pstat.setString(1, npass);
					pstat.setString(2,login_id);
					pstat.setString(3,email);
					int status = pstat.executeUpdate();
					if(status==1) {
						String msg = "Password updated succesfully."
								+" Use new password for login";
						request.setAttribute("success", msg);
						rd = request.getRequestDispatcher("updatepass.jsp");
						rd.forward(request, response);
					}else {
						PrintWriter pw = response.getWriter();
						response.setContentType("text/html");
						pw.print("Database error occured");
						response.sendRedirect("passrecovery.jsp");
					}
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				finally {
					if(con!=null) {
						try {
							MyDbUtil.closeConnection(con);
						}catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}//catch
					}//if
				}//finally
			}
			else {
				request.setAttribute("error", "OTP was incorrect");
				rd = request.getRequestDispatcher("passrecovery.jsp");
				rd.forward(request, response);
			}
		}//else
		
	}//dopost

}
