package nit.com.controler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HouseImageDownload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Connection con = null;
     Statement stmt = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     byte[] data = null;
     
     try {
    	 String name = request.getParameter("img_name");
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			String sql = "select * from house where name='"+name+"'";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				data = rs.getBytes("photo");
			}
			OutputStream os = response.getOutputStream();
			os.write(data);
			os.close();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			if (con!=null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}
}