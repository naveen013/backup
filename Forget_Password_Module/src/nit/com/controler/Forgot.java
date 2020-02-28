package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String passsword = request.getParameter("pass");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			String sql = "update forgot123 set password=? where email=?";
			pstmt  =con.prepareStatement(sql);
			pstmt.setString(1, passsword);
			pstmt.setString(2, email);
			
			 result = pstmt.executeUpdate();
			 if(result>0){
				 response.sendRedirect("update.jsp");
			 }else {
				response.sendRedirect("error.jsp");
			}
			
			
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
		}//finally
	}

}
