package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.com.bo.Owner;

public class ViewOwner extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		List<Owner>list = new ArrayList<Owner>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			stmt = con.createStatement();
			String sql = "select * from owner";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				//long userid = rs.getLong("userid");
				String username = rs.getString("username");
				String password1 = rs.getString("password");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				
				Owner ow = new Owner();
				//ow.setId(userid);
				ow.setUsername(username);
				ow.setPassword(password1);
				ow.setMobile(mobile);
				ow.setEmail(email);
				ow.setGender(gender);
				ow.setAddress(address);
				
				list.add(ow);
				
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
		}
		request.setAttribute("ownerlist", list);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("owner_view1.jsp");
		rd.forward(request, response);
	}

}
