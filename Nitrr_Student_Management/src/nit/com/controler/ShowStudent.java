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

import nit.com.bo.Student;

public class ShowStudent extends HttpServlet {
	

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
		
		String sql = "select *from  nitStudent";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			long rollno = rs.getLong("Roll_no");
			String name = rs.getString("Stu_Name");
			long enrollmentno = rs.getLong("stu_enrollment_no");
			long sem = rs.getLong("Semester");
			String course = rs.getString("course");
			String branch = rs.getString("Branch");
			String email = rs.getString("email");
			
			Student stu = new Student();
			stu.setRollno(rollno);
			stu.setName(name);
			stu.setEnrollmentno(enrollmentno);
			stu.setSem(sem);
			stu.setCourse(course);
			stu.setBranch(branch);
			stu.setEmail(email);
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
     rd = request.getRequestDispatcher("Stu_View.jsp");
     rd.forward(request, response);
	}

}
