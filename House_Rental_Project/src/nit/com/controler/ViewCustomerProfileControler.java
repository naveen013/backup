package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.com.bo.Customer;
import nit.com.bo.Owner;

public class ViewCustomerProfileControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Customer>list = new ArrayList<Customer>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		Customer customer =null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);

			String sql = "select * from customer";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				String name = rs.getString("username");
				String Password = rs.getString("password");
				long Mobile = rs.getLong("mobile");
				String Email = rs.getString("email");
				String Gender = rs.getString("gender");
				String Address = rs.getString("address");
		
				 customer = new Customer();
				customer.setUsername(name);
				customer.setPassword(Password);
				customer.setMobile(Mobile);
				customer.setEmail(Email);
				customer.setGender(Gender);
				customer.setAddress(Address);
				list.add(customer);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("customerlist",list);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("customer_view.jsp");
		rd.forward(request, response);
	}

}
