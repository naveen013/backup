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

import nit.com.bo.Customer;

public class ViewAllCustomerControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		List<Customer>list = new ArrayList<Customer>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			stmt  = con.createStatement();
			String sql = "select * from customer";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String userPassword = rs.getString("password");
				String email = rs.getString("email");
				long mobile = rs.getLong("mobile");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				
			Customer	cust = new Customer();
				cust.setUsername(username);
				cust.setPassword(userPassword);
				cust.setEmail(email);
				cust.setMobile(mobile);
				cust.setGender(gender);
				cust.setAddress(address);
				
				list.add(cust);
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
		request.setAttribute("customerlist", list);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("viewall_customer.jsp");
	    rd.forward(request, response);
	}

}
