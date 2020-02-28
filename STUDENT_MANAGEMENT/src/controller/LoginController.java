package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sis.com.bo.User;

 
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId  = request.getParameter("login_id");
		String loginPassword  = request.getParameter("login_password");
		

	Connection con  = null;
	PreparedStatement pstmt  = null;
	ResultSet rs=null;
	User userObject  = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String dbuser="system";
		String dbpassword="root";
		con  = DriverManager.getConnection(url, dbuser, dbpassword);
		String sql="select * from stu_user where login_id=? and login_password=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, loginId);
		pstmt.setString(2, loginPassword);
		rs  =pstmt.executeQuery();
		if(rs.next()) {
			long id = rs.getLong("id");
			String name = rs.getString("NAME");
			String role  = rs.getString("ROLE");
			userObject  = new User();
			userObject.setId(id);
			userObject.setName(name);
			userObject.setLoginId(loginId);
			userObject.setRole(role); 
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	if(userObject!=null) {
		HttpSession session = request.getSession();
		session.setAttribute("user", userObject);
		response.sendRedirect("home.jsp");
		
	}else{
		response.sendRedirect("login.jsp");
	}
	
	}	

}
