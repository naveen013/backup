package nit.com.controler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	byte []data = null;
	response.setContentType("image/jpeg");

	try {
		String name = request.getParameter("stu_name");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String password = "root";
		con = DriverManager.getConnection(url,user,password);
		stmt = con.createStatement();
		String sql = "select * from employe2 where name = "+name;
		rs  =stmt.executeQuery(sql);
		if (rs.next()) {
			data = rs.getBytes("photo");
		}
		OutputStream os = response.getOutputStream();
		os.write(data);
		os.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		try {
			if(con!=null){
				con.close();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	}

	
}
