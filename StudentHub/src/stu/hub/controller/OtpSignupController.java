package stu.hub.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 * Servlet implementation class OtpSignupController
 */
@WebServlet("/OtpSignupController")
public class OtpSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OtpSignupController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    String OTP = "";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		User us=null;
		Random ran = new Random();
		RequestDispatcher rd = null;
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String login_id = request.getParameter("login_id");
		String email=request.getParameter("email");
		String address=request.getParameter("addr");
		String contactNo = request.getParameter("mobile");
		String institute = request.getParameter("institute");
		String course=request.getParameter("course");
		String yoa = request.getParameter("year");
		int yearOfAdmission = Integer.parseInt(yoa);
		String password=request.getParameter("password");
		System.out.println(address);
		
		if(name.isEmpty()||gender.isEmpty()||login_id.isEmpty()||email.isEmpty()
				||address.isEmpty()||institute.isEmpty()||yoa.isEmpty()
				||password.isEmpty()||contactNo.isEmpty()) {
			
			request.setAttribute("formfield","Fill the empty fields");
			rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request,response);
		}
		
		us = new User();
		us.setName(name);
		us.setGender(gender);
		us.setLogin_id(login_id);
		us.setAddress(address);
		us.setContactNo(contactNo);
		us.setEmail(email);
		us.setInstitute(institute);
		us.setCourse(course);
		us.setPassword(password);
		us.setYearOfAdmission(yearOfAdmission);
		for(int i=1;i<=6;i++) {
			int no = ran.nextInt(9);
			OTP = no+""+OTP;
		}
		
		boolean otpstatus = false;
		try {
			otpstatus = SendMail.sendotp(email, OTP);
		}catch(Exception e) {
			pw.print("Please check your id or connection");
			e.printStackTrace();
		}
		
		if(otpstatus) {
			System.out.println("Otp sent to email id successfully");
			request.setAttribute("signupuser",us);
			rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request,response);
		}
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String button = request.getParameter("button");
		if(button.equals("1")) {
			OTP="";
			doGet(request, response);
		}else {
			RequestDispatcher rd = null;
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String login_id = request.getParameter("login_id");
			String email=request.getParameter("email");
			String address = request.getParameter("addr");
			String contactNo = request.getParameter("mobile");
			String institute = request.getParameter("institute");
			String course=request.getParameter("course");
			String yoa = request.getParameter("year");
			int yearOfAdmission = Integer.parseInt(yoa);
			String password = request.getParameter("password");
			String cpass = request.getParameter("c_pass");
			String otp = request.getParameter("OTP");
		/*	pw.print(name);
			pw.print(gender);
			pw.print(login_id);
			pw.print(email);
			pw.print(address);
			pw.print(contactNo);
			pw.print(institute);
			pw.print(course);
			pw.print(yoa);
			pw.print(password);
			pw.print(cpass);
			pw.print(otp);*/
			if(name.isEmpty()||gender.isEmpty()||login_id.isEmpty()||email.isEmpty()
					||address.isEmpty()||institute.isEmpty()||yoa.isEmpty()
					||password.isEmpty()||contactNo.isEmpty()||cpass.isEmpty()
					||course.isEmpty()) {
				
				request.setAttribute("formfield","Fill the empty fields");
				rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}

			if(otp.isEmpty()) {
				request.setAttribute("formfield", "Please Enter Your OTP");
				rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
			
			if(!password.equals(cpass)) {
				request.setAttribute("formfield","Password and Confirm Password should be same");
				rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request,response);
			}
			
			if(otp.equals(OTP)) {
				Connection con = null;
				PreparedStatement pstat = null;
				ResultSet rs = null;
				int isInserted=0;
				int s_id=0;
				try {
					con = MyDbUtil.getConnection();
					String sql = "INSERT INTO SH_USER (SID,LOGIN_ID,NAME,GENDER,EMAIL_ID,PASSWORD,CONTACT,"
							+ "ADDRESS,INSTITUTE,COURSE,YEAR_OF_ADMISSION,SIGNUP_TIME) VALUES((SELECT NVL(MAX(SID),0)+1 FROM SH_USER),?,?,?,?,?,?,?,?,?,?,sysdate)";
					String seq = "SELECT MAX(SID) FROM SH_USER";
					pstat = con.prepareStatement(sql);
					pstat.setString(1,login_id );
					pstat.setString(2,name);
					pstat.setString(3,gender);
					pstat.setString(4,email);
					pstat.setString(5,password);
					pstat.setString(6,contactNo);
					pstat.setString(7,address);
					pstat.setString(8,institute);
					pstat.setString(9,course);
					pstat.setInt(10,yearOfAdmission);
					System.out.println("setting value to insert in db");
					isInserted = pstat.executeUpdate();
					System.out.println(isInserted);
					pstat =  con.prepareStatement(seq);
					rs = pstat.executeQuery();
					if(rs.next()) {
						 s_id = rs.getInt(1);
					}
					
				
				} catch (SQLException e) {
					System.out.println("Database Error");
					request.setAttribute("formfield", "Error while inserting record");
					rd = request.getRequestDispatcher("signup.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				}
				
					
				finally {
					if(con!=null) {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}//if
				}//finally
				
				
				if(isInserted==1) {
					String message = "Your registeration/serial Id is = "+s_id;
					request.setAttribute("regmes",message );
					rd = request.getRequestDispatcher("registeration.jsp");
					rd.forward(request, response);
				}
				
				
			}else {
				doGet(request,response);
			}
		}//else
	}//doPost

}
