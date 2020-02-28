package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.Student;

public class AddStudentController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   String idStr = request.getParameter("stu_id");
		   String name = request.getParameter("stu_name");
		   String email = request.getParameter("stu_email");
		   String branch = request.getParameter("stu_branch");
		   
		  long id = Long.parseLong(idStr);
		  long branchId = Long.parseLong(branch);
		  
        
		 
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			//System.out.println(id);
			con = DriverManager.getConnection(url,user,password);
			//String sql = "insert into Student (StuId,StuName,StuEmail,BranchId) values (id,'name','email',branchId)";
			String sql = "insert into Student (StuId,StuName,StuEmail,BranchId) values (?,?,?,?)";
			pstmt  =con.prepareStatement(sql);
			
			pstmt.setLong(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setLong(4,branchId);
			result = pstmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		}catch (SQLException e) {
          e.printStackTrace(); 
		}try {
			if (con!=null) {
				con.close();
			}
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		if(result==1) {
			request.setAttribute("insert_msg", "your record inserted "+id);
		}else {
			request.setAttribute("insert_msg", "your record NOT inserted "+id);
		}
		RequestDispatcher rd = request.getRequestDispatcher("add_stu_msg.jsp");
		rd.forward(request, response);
	}
	
}
