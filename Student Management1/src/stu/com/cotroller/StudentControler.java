package stu.com.cotroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

import stu.com.bo.Student;

public class StudentControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     
		   List<Student>list = new ArrayList<Student>();
		   
		     Connection con  = null;
		     Statement stmt = null;
		     ResultSet rs = null;
		     try {	
		    	    Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "system";
					String password = "root";
					con = DriverManager.getConnection(url,user,password);
					stmt = con.createStatement();
				String sql = "select *from Students";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					long id = rs.getLong("id");
					String firstName = rs.getString("first_name");
					String lastName= rs.getString("last_name");
					String sex = rs.getString("sex");
					Date birthdate  = rs.getDate("birthdate");
					String phone = rs.getString("phone");
					String Address = rs.getString("Address");
					
					Student stu = new Student();
					stu.setId(id);
					stu.setFirstName(firstName);
					stu.setLastName(lastName);
					stu.setSex(sex);
					stu.setBirthDate(birthdate);
					stu.setAddress(Address);
					stu.setPhone(phone);
					list.add(stu);
					
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
		     
		     request.setAttribute("stulist", list);
		     RequestDispatcher rd = null;
		     rd = request.getRequestDispatcher("stu_view.jsp");
		     rd.forward(request, response);
	}

}
