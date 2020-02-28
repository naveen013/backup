package nit.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import nit.com.bo.Owner;

public class ViewOwnerProfileControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		//String useridStr = request.getParameter("username");
		List<Owner>list = new ArrayList<Owner>();
		Connection con = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   String name2=request.getParameter("abc");
	   PrintWriter pw=response.getWriter();
	   pw.print("--------"+name2);
	   Owner owner=null;
	  
	   try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);

			String sql = "select *from owner where username='"+name2+"'";
			pstmt = con.prepareStatement(sql);
			//pstmt.setLong(1,userid);
			rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				long id = rs.getLong("userid");
				String name = rs.getString("username");
				String Password = rs.getString("password");
				String Mobile = rs.getString("mobile");
				String Email = rs.getString("email");
				String Gender = rs.getString("gender");
				String Address = rs.getString("address");
		
				 owner = new Owner();
				owner.setId(id);
				owner.setUsername(name);
				owner.setPassword(Password);
				owner.setMobile(Mobile);
				owner.setEmail(Email);
				owner.setGender(Gender);
				owner.setAddress(Address);
				//list.add(owner);
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
          request.setAttribute("ownerlist",	owner);
          RequestDispatcher rd = null;
          rd= request.getRequestDispatcher("owner_view.jsp");
          rd.forward(request, response);
	}

}
