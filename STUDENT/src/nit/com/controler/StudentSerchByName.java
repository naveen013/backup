package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.com.bo.Student;

public class StudentSerchByName extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   String name = request.getParameter("Stu_Name");
		   Student foundStu = null;
		   
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
			  String sql = "select * from nitStudent where Stu_Name like '"+name+"'";
			  
			  rs = stmt.executeQuery(sql);
			  while (rs.next()) {
				long rollno = rs.getLong("Roll_no");
				String StuName = rs.getString("Stu_Name");
				long enrollmentno = rs.getLong("stu_enrollment_no");
				long Sem = rs.getLong("Semester");
				String course = rs.getString("course");
				String branch = rs.getString("Branch");
				String email = rs.getString("email");
				
				foundStu = new Student();
				foundStu.setRollno(rollno);
				foundStu.setName(StuName);
				foundStu.setEnrollmentno(enrollmentno);
				foundStu.setCourse(course);
				foundStu.setBranch(branch);
				foundStu.setEmail(email);
				
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
		   if (foundStu==null) {
			   //not found
              String notFoundMsg = "there are no such student exists for given name"+name;	
  			request.setAttribute("not_found_msg", notFoundMsg); 
  			rd  = request.getRequestDispatcher("stu_search.jsp");
		}else{
			//found 
			request.setAttribute("stu",foundStu);
			rd  = request.getRequestDispatcher("stu_search_result.jsp");
		}//end of else
		   rd.forward(request, response);
	}//end of main

}//end of class 
