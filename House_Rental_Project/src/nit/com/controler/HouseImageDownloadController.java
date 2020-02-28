package nit.com.controler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HouseImageDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		byte []data = null;
		
		
		response.setContentType("image/jpeg");
		
		try {
			String userId = request.getParameter("img_name");
			System.out.println(userId);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			String sql = "select *from owner where username='"+userId+"'";
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
				if(con!=null){
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
