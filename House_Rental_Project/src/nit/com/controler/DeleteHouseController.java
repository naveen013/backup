package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteHouseController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String name = request.getParameter("name");
		Connection con = null;
		Statement stmt = null;
		
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="root";
		
			con  = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			String sql = "delete from house where name='"+name+"'";
			result = stmt.executeUpdate(sql);
					
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
			}catch (Exception e) {
               e.printStackTrace();  
			}
		}
		if(result==1) {
			request.setAttribute("delete_msg", "your record deleted-:"+name);
		}else {
			request.setAttribute("delete_msg", "your record NOT deleted -:"+name);	
		}
		RequestDispatcher rd = request.getRequestDispatcher("delete_house_msg.jsp");
		rd.forward(request, response);
	

	}

}
