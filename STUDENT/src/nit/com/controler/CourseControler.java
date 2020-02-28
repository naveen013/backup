package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
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

import nit.com.bo.Course;

public class CourseControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Course> list = new ArrayList<Course>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url="Jdbc:oracle:thin:@localhost:1521:XE";
	         String user = "system";
	         String password = "root";
	         con = DriverManager.getConnection(url,user,password);
			String sql = "select * from Regular_Course";
			
			stmt  = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				long courseNo = rs.getLong("course_no");
				String courseName = rs.getString("course_name");
				long noOfSeat = rs.getLong(" Avilable_seat");//Avilable_seat
				long duration = rs.getLong("Duration");
				String eligibility = rs.getString("Eligibility");
				String subj = rs.getString("Subject");
				String admMode = rs.getString("Admission_mode");
				String courseType = rs.getString(" course_type");
				String studyMode = rs.getString("Study_mode");
				
				Course course = new Course();
				course.setCourseId(courseNo);
				course.setCourseName(courseName);
				course.setNoOfSeat(noOfSeat);
				course.setDuration(duration);
				course.setEligibility(eligibility);
				course.setSubjName(subj);
				course.setAdmMode(admMode);
				course.setCourseType(courseType);
				course.setStudyMode(studyMode);
				list.add(course);
				
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
				// TODO: handle exception
			}//catch
		}//end of finally
		request.setAttribute("courselist", list);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("course_view.jsp");
		rd.forward(request, response);
	}// end of main

}// end of class
