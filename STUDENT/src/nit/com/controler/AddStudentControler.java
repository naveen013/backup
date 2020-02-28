package nit.com.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddStudentControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   String StrRollNo = request.getParameter("stu_Rollno");
	   String name = request.getParameter("stu_Name");
	   String Strenrollment = request.getParameter("stu_enrollment");
	   String semester = request.getParameter("sem");
	   String course = request.getParameter("course");
	   String branch = request.getParameter("branch");
	   String email = request.getParameter("stu_Email");
	   
	   long RollNo = Long.parseLong(StrRollNo);
	   long Enrollmetn = Long.parseLong(Strenrollment);
	   
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   int resultSet = 0;
	   
	   try {
		  /* Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			//System.out.println(id);
			con = DriverManager.getConnection(url,user,password);
			//String sql = "insert into Student (StuId,StuName,StuEmail,BranchId) values (id,'name','email',branchId)";
			String sql = "insert into Student (StuId,StuName,StuEmail,BranchId) values (?,?,?,?)";
			pstmt  =con.prepareStatement(sql);*/
		   
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url="Jdbc:oracle:thin:@localhost:1521:XE";
         String user = "system";
         String password = "root";
         con = DriverManager.getConnection(url,user,password);
         String sql = " insert into nitStudent(Roll_no,Stu_Name,stu_enrollment_no,Semester,course,Branch,email)  values(?,?,?,?,?,?,?)";
         pstmt = con.prepareStatement(sql);
         
         pstmt.setLong(1,RollNo);
         pstmt.setString(2, name);
         pstmt.setLong(3, Enrollmetn);
         pstmt.setString(4, semester);
         pstmt.setString(5, course);
         pstmt.setString(6, branch);
         pstmt.setString(7, email);
        resultSet =  pstmt.executeUpdate();
		   
	} catch (ClassNotFoundException e) {
        e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}catch (Exception e) {
        e.printStackTrace();
	}try {
			if (con!=null) {
				con.close();
			}	
		}catch (SQLException e) {
           e.printStackTrace();
		}catch (Exception e) {
           e.printStackTrace();
		}//end of catch
	if (resultSet == 1) {
		request.setAttribute("insert_message", "Record inserted"+RollNo);
	}else{
		request.setAttribute("insert_message", "Record not inserted"+RollNo);
	}
	RequestDispatcher rd = request.getRequestDispatcher("add_stu_msg.jsp");
	rd.forward(request, response);
	
	}//end of main

}//end of class
