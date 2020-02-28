package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.com.mail.SendMail;

public class CustomerForgetPassword extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String username = request.getParameter("user");
	
		Connection con = null;
		Statement pstmt = null;
		ResultSet rs = null;
		//SendMail send=null;
		String password=null;
		
		System.out.println(email);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String dbuser = "system";
			String dbpassword = "root";
			con = DriverManager.getConnection(url,dbuser,dbpassword);
			pstmt = con.createStatement();
			String sql="select * from customer where username='"+username+"'";
			// String sql="SELECT  email FROM owner WHERE email = '"+email+"'";
			rs = pstmt.executeQuery(sql);
			
			if(rs.next()) {
				
				password=rs.getString("password");
				System.out.println(password);
			}
			password=password+"a1";
			String sql1="update customer set password ='"+password+"'"+ "where username='"+username+"'" ;
			pstmt=con.createStatement();
			pstmt.executeUpdate(sql1);
			System.out.println(password);
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				  if (con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
   if(password!=null){
	   System.out.println(password);
	   try {
		   //SendMail s=null;
		   System.out.println(email);
		   System.out.println(password);
	boolean b=	SendMail.sendMail(email,password);
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
	}

	
}
