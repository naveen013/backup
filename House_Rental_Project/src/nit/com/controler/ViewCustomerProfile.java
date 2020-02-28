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

import jdk.nashorn.internal.ir.ForNode;
import nit.com.bo.Customer;
import nit.com.bo.CustomerLogin;

public class ViewCustomerProfile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Customer>list = new ArrayList<Customer>();
		System.out.println(list);
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		   String name2=request.getParameter("abc");
		   
		Customer cust = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password1 = "root";
			con = DriverManager.getConnection(url,user,password1);
			String sql = "select *from customer where username='"+name2+"'";
			stmt = con.createStatement();
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
            	 String username = rs.getString("username");
            	 String password = rs.getString("password");
            	 String email = rs.getString("email");
            	 long mobile = rs.getLong("mobile");
            	 String gender = rs.getString("gender");
            	 String adddress = rs.getString("address");
               
            	 cust = new Customer();
            	 cust.setUsername(username);
            	 cust.setPassword(password);
            	 cust.setEmail(email);
            	 cust.setMobile(mobile);
            	 cust.setGender(gender);
            	 cust.setAddress(adddress);
            	// list.add(cust);
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
		if(cust!=null){
		request.setAttribute("custlist",cust);
	    RequestDispatcher rd = null;
	    rd = request.getRequestDispatcher("cust_view_profile.jsp");
	    rd.forward(request, response);
		}else{
			System.out.println("Error");
		}
	}

}
