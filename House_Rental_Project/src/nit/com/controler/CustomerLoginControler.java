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

import nit.com.bo.Customer;
import nit.com.bo.CustomerLogin;
import nit.com.bo.OwnerLogin;

public class CustomerLoginControler extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(name);
		//System.out.println(password);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CustomerLogin customerObj = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String dbuser = "system";
			String dbpassword = "root";
			con = DriverManager.getConnection(url,dbuser,dbpassword);
			String sql="select * from customer where username=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String username = rs.getString("username");
				customerObj  = new CustomerLogin();
				customerObj.setUsername(username);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
           e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (customerObj!=null) {
			request.setAttribute("customer", customerObj);
			RequestDispatcher rd = null;		
			rd = request.getRequestDispatcher("customer_login_view.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("customer_login.jsp");
		}
	}

}