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
import nit.com.bo.House;

public class HouseSearchController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loc = request.getParameter("location");
		System.out.println(loc);
		
		List<House>list = new ArrayList<House>();
		House foundHouse = null;
		
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
			  
			  String sql = "select * from house where location like '"+loc+"'";
			  rs = stmt.executeQuery(sql);
			  while (rs.next()) {
				String name = rs.getString("name");
				String locaton = rs.getString("location");
				String category = rs.getString("category");
				long bedroom = rs.getLong("bedroom");
				String email = rs.getString("email");
				long mobile = rs.getLong("mobile");
				
				foundHouse = new House();
				foundHouse.setName(name);
				foundHouse.setLocation(locaton);
				foundHouse.setCategory(category);
				foundHouse.setBedroom(bedroom);
				foundHouse.setEmail(email);
				foundHouse.setMobile(mobile);
				
				list.add(foundHouse);
				System.out.println("fjfgkk");
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
		}//end of finally

		   RequestDispatcher rd = null;
		   if (foundHouse==null) {
			   //not found
           String notFoundMsg = "there are no such student exists for given name"+loc;	
			request.setAttribute("not_found_msg",notFoundMsg); 
			rd  = request.getRequestDispatcher("house_search_form.jsp");
		}else{
			//found 
			String foundMsg = "location found successfully"+loc;
			request.setAttribute("foundMsg",list);
			rd  = request.getRequestDispatcher("house_search_result.jsp");
		}//end of else
		   rd.forward(request, response);
	}

}
