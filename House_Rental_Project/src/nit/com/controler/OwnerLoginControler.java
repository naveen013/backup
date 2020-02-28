package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nit.com.bo.Owner;
import nit.com.bo.OwnerLogin;

public class OwnerLoginControler extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		String userName = request.getParameter("username");
		String loginPassword = request.getParameter("password");
		//System.out.println(userName);
		//System.out.println(loginPassword);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OwnerLogin OwnerObject = null;
		//Owner OwnerObject = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String dbuser = "system";
			String dbpassword = "root";
			con = DriverManager.getConnection(url,dbuser,dbpassword);
			String sql="select * from owner where username=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, loginPassword);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//long id = rs.getLong("id");
				String name = rs.getString("username");
				OwnerObject  = new OwnerLogin();
				//OwnerObject.setId(id);
				OwnerObject.setUsername(name);
				//OwnerObject.setEmail(loginId);
			}
			//OwnerObject  = new OwnerLogin();
			//OwnerObject.setUsername(userName);
		} catch (ClassNotFoundException e) {
           e.printStackTrace();
		}catch (SQLException e) {
           e.printStackTrace();
		}finally{
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
							e.printStackTrace();
		}//catch
		
	}//end of finally
		if(OwnerObject!=null) {
		//	HttpSession session = request.getSession();
			request.setAttribute("owner",OwnerObject);
			RequestDispatcher rd = null;
            rd= request.getRequestDispatcher("client_login_view.jsp");
            rd.forward(request, response);
			//response.sendRedirect("client_login_view.jsp");
			
		}else{
			response.sendRedirect("owner_login.jsp");
		}
		/*
		 *  request.setAttribute("stulist", list);
              RequestDispatcher rd = null;
              rd= request.getRequestDispatcher("student_view.jsp");
              rd.forward(request, response);
		 * 
		 */
		
	}//end of main
}//end of class
