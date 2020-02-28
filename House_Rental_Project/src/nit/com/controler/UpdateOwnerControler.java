package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.com.bo.Owner;

public class UpdateOwnerControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("username");
		//System.out.println(name);
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Owner ow = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="root";
			con  = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			String sql = "select * from owner where username="+name;
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				long id = rs.getLong("userid");
				String username = rs.getString("username");
				String password1 = rs.getString("password");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				
				ow = new Owner();
				ow.setId(id);
				ow.setUsername(username);
				ow.setPassword(password1);
				ow.setMobile(mobile);
				ow.setEmail(email);
				ow.setGender(gender);
				ow.setAddress(address);
			}
			//System.out.println(ow);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null){
					con.close();
				}
				
			} catch (SQLException e) {
              e.printStackTrace();
			}
		}
		request.setAttribute("ow",ow);
		RequestDispatcher rd = request.getRequestDispatcher("update_owner_form.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idstr = request.getParameter("userid");
		String name = request.getParameter("username");
		String pasword = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		
		long id = Long.parseLong(idstr);
		
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   int result = 0;
		   try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   String url = "jdbc:oracle:thin:@localhost:1521:XE";
			   String user = "system";
			   String password = "root";
			   con = DriverManager.getConnection(url,user,password);
			   String sql = "update owner set userid=?,password=?,mobile=?,email=?,gender=?,address=?";
			   pstmt = con.prepareStatement(sql);
			   
			   pstmt.setLong(1, id);
			   pstmt.setString(2, pasword);
			   pstmt.setString(3, mobile);
			   pstmt.setString(4, email);
			   pstmt.setString(5,gender);
			   pstmt.setString(6, address);
			   result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
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
		   if(result==1) {
				request.setAttribute("update_msg", "your record update "+name);
			}else {
				request.setAttribute("update_msg", "your record NOT update "+name);
			}
			RequestDispatcher rd = request.getRequestDispatcher("update_msg.jsp");
			rd.forward(request, response);
		
	}

}
