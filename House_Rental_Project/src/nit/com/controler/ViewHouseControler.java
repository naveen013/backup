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

import nit.com.bo.House;

public class ViewHouseControler extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		List<House>list = new ArrayList<House>();
		
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
			String sql = "select *from house";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				 String name = rs.getString("name");
				String location = rs.getString("location");
				String category = rs.getString("category");
				long bedroom= rs.getLong("bedroom");
				String email = rs.getString("email");
				long mobile = rs.getLong("mobile");
				
				House house = new House();
				house.setName(name);
				house.setLocation(location);
				house.setCategory(category);
				house.setBedroom(bedroom);
				house.setEmail(email);
				house.setMobile(mobile);
				list.add(house);
			}		
		}catch (ClassNotFoundException e) {
              e.printStackTrace();
		}catch (SQLException e) {
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
              request.setAttribute("houselist", list);
              RequestDispatcher rd = null;
              rd= request.getRequestDispatcher("house1_view.jsp");
              rd.forward(request, response);

	}//end of doget

}//end of class
