package nit.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.com.bo.Customer;

public class CustomerSearchControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     String name = request.getParameter("username");
	     Customer foundCustmer = null;
	     
	     Connection con = null;
	     Statement stmt = null;
         ResultSet rs = null;
	     
	     try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "system";
				String password = "root";
				con = DriverManager.getConnection(url,user,password);
				String sql = "select * from customer where username like+name";
				  while (rs.next()) {
					  String UserName = rs.getString("username");
					  String password1 = rs.getString("password");
					  String email = rs.getString("email");
					  long mobile = rs.getLong("mobile");
					  String gender = rs.getString("gender");
					  String address = rs.getString("address");
					  

					     System.out.println("hello "+UserName);
					     System.out.println("hello "+password1);
					
					  foundCustmer = new Customer();
					  foundCustmer.setUsername(UserName);
					  foundCustmer.setPassword(password1);
					  foundCustmer.setEmail(email);
					  foundCustmer.setMobile(mobile);
					  foundCustmer.setGender(gender);
					  foundCustmer.setAddress(address);	  
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

	     RequestDispatcher rd = null;
		   if (foundCustmer==null) {
			   //not found
            String notFoundMsg = "there are no such Customer exists for given name"+name;	
			request.setAttribute("not_found_msg", notFoundMsg); 
			rd  = request.getRequestDispatcher("customer_serch.jsp");
		}else{
			//found 
			request.setAttribute("cust",foundCustmer);
			rd  = request.getRequestDispatcher("customer_search_result.jsp");
		}//end of else
		   rd.forward(request, response);
	
	}

}
