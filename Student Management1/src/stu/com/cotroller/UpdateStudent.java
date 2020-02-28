package stu.com.cotroller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.com.bo.Student;

public class UpdateStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		String StrId = request.getParameter("stuid");
		long id = Long.parseLong(StrId);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Student stu = null;
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   String url = "jdbc:oracle:thin:@localhost:1521:XE";
			   String user = "system";
			   String password = "root";
			   con = DriverManager.getConnection(url,user,password);
			stmt = con.createStatement();
			String sql = "select *from Students where id="+id;
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				long Id = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName= rs.getString("last_name");
				String sex = rs.getString("sex");
				Date birthdate  = rs.getDate("birthdate");
				String phone = rs.getString("phone");
				String Address = rs.getString("Address");
				
				 stu = new Student();
				stu.setId(id);
				stu.setFirstName(firstName);
				stu.setLastName(lastName);
				stu.setSex(sex);
				stu.setBirthDate(birthdate);
				stu.setAddress(Address);
				stu.setPhone(phone);
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
			}catch (Exception e) {
              e.printStackTrace();
			}
			
		}
		request.setAttribute("stu",stu);
		RequestDispatcher rd = request.getRequestDispatcher("update_stu_form.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId = request.getParameter("id");
		String firstName = request.getParameter("first_name");
		String lastName= request.getParameter("last_name");
		String sex = request.getParameter("sex");
		String birthdateStr  = request.getParameter("birthdate");//("birthdate");
		String phone = request.getParameter("phone");
		String Address = request.getParameter("Address");
		
		
		long id = Long.parseLong(strId);
	//	Date birthdate =Date.parse(birthdateStr);
		try {
			java.util.Date d1= new SimpleDateFormat("dd/mm/yy").parse(birthdateStr);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		int resultSet = 0;
		
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   String url = "jdbc:oracle:thin:@localhost:1521:XE";
			   String user = "system";
			   String password = "root";
			   con = DriverManager.getConnection(url,user,password);
			   String sql="update Students set first_name=?,last_name=?,sex=?,birthdate=?,phone=?,Address=? where id=?";
			   pstmt = con.prepareStatement(sql);
			
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
		}//end of finally
		if (resultSet==1) {
			request.setAttribute("update msg", "your record successfuly updated"+id);
		}else{
			request.setAttribute("update msg", "your not updated"+id);
		}
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("update_msg.jsp");
				rd.forward(request, response);
	}//end of main

}// end of class