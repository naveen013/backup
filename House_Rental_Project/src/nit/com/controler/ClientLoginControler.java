package nit.com.controler;

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

import nit.com.bo.Client;;

 
public class ClientLoginControler extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId  = request.getParameter("username");
		String loginPassword  = request.getParameter("password");
		

	Connection con  = null;
	PreparedStatement pstmt  = null;
	ResultSet rs=null;
	Client clientObject  = null;

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String dbuser="system";
		String dbpassword="root";
		con  = DriverManager.getConnection(url, dbuser, dbpassword);
		String sql="select * from client where login_id=? and login_password=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, loginId);
		pstmt.setString(2, loginPassword);
		rs  =pstmt.executeQuery();
		if(rs.next()) {
			long id = rs.getLong("id");
			String name = rs.getString("NAME");
			String role  = rs.getString("ROLE");
			clientObject  = new Client();
			clientObject.setId(id);
			clientObject.setName(name);
			clientObject.setLoginId(loginId);
			clientObject.setRole(role); 
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
		
	
	if(clientObject!=null) {
		HttpSession session = request.getSession();
		session.setAttribute("user", clientObject);
		response.sendRedirect("client_login_view1.jsp");
		
	}else{
		response.sendRedirect("client_login.jsp");
	}
	
	}	

}
