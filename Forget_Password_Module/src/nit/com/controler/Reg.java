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

/**
 * Servlet implementation class Reg
 */
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("uname");
		String address = request.getParameter("add");
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
			String sql = "insert into forgot123 values (?,?,?,?)";
			pstmt  =con.prepareStatement(sql);
			
			pstmt.setString(1,userName);
			pstmt.setString(2,address);
			pstmt.setString(3,email);
			pstmt.setString(4,passsword);
			 result = pstmt.executeUpdate();
			 if(result>0){
				 response.sendRedirect("welcome.jsp");
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
		
	}//dopost

}//end of class
