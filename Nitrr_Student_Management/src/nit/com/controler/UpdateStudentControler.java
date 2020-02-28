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

import nit.com.bo.Student;

public class UpdateStudentControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		String StrRollno = request.getParameter("sturollno");
		long Rollno = Long.parseLong(StrRollno);
		
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
			String sql = "select *from nitStudent where Roll_no="+Rollno;
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				long rollno = rs.getLong("Roll_no");
				String name = rs.getString("Stu_Name");
				long enrollmentno = rs.getLong("stu_enrollment_no");
				long sem = rs.getLong("semester");
				String course = rs.getString("course");
				String branch = rs.getString("Branch");
				String email = rs.getString("email");
				
				stu = new Student();
				stu.setRollno(rollno);
				stu.setName(name);
				stu.setEnrollmentno(enrollmentno);
				stu.setSem(sem);
				stu.setCourse(course);
				stu.setBranch(branch);
				stu.setEmail(email);
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

		String strRollno = request.getParameter("Roll_no");
		String name = request.getParameter("Stu_Name");
		String Strenrollmentno = request.getParameter("stu_enrollment_no");
		String sem = request.getParameter("semester");
		String course = request.getParameter("course");
		String branch = request.getParameter("Branch");
		String email = request.getParameter("email");
		
		long rollno = Long.parseLong(strRollno);
		long enrollmentno = Long.parseLong(Strenrollmentno);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int resultSet = 0;
		
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   String url = "jdbc:oracle:thin:@localhost:1521:XE";
			   String user = "system";
			   String password = "root";
			   con = DriverManager.getConnection(url,user,password);
			   String sql="update nitStudent set Stu_Name=?,stu_enrollment_no=?,Semester=?,course=?,Branch=?,email=? where Roll_no=?";
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
			request.setAttribute("update msg", "your record successfuly updated"+rollno);
		}else{
			request.setAttribute("update msg", "your not inserted"+rollno);
		}
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("update_msg.jsp");
				rd.forward(request, response);
	}//end of main

}// end of class
