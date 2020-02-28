package controller;

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

import sis.com.bo.Student;


public class UpdateStudentController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id  = request.getParameter("stuid");
		

	Connection con  = null;
	Statement stmt  = null;
	ResultSet rs=null;
	Student stu  = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String password="root";
		con  = DriverManager.getConnection(url, user, password);
		stmt = con.createStatement();
		String sql="select * from  Student where stuid="+id;
		rs  =stmt.executeQuery(sql);
		if(rs.next()) {
			long Id = rs.getLong("StuId");
			String name = rs.getString("StuName");
			String email  = rs.getString("StuEmail");
			long branchId = rs.getLong("BranchId");
				stu  = new Student();
				stu.setId(Id);
				stu.setName(name);
				stu.setEmail(email);
				stu.setBrachId(branchId);
		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
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
		request.setAttribute("stu",stu);
		RequestDispatcher rd = request.getRequestDispatcher("update_stu_form.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		   String idStr = request.getParameter("stuid");
		   String name = request.getParameter("stuname");
		   String email = request.getParameter("stuemail");
		   String branch = request.getParameter("stubranch");
		   
		  long id=Long.parseLong(idStr);
		   
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   int result = 0;
		   try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   String url = "jdbc:oracle:thin:@localhost:1521:XE";
			   String user = "system";
			   String password = "root";
			   con = DriverManager.getConnection(url,user,password);
			   String sql="update Student set stuname=?,stuemail=? where stuid=?";
			   pstmt = con.prepareStatement(sql);
			   
				pstmt.setString(1,name);
				pstmt.setString(2,email);
				pstmt.setLong(3,id);
				result  =pstmt.executeUpdate();
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
				request.setAttribute("update_msg", "your record update "+id);
			}else {
				request.setAttribute("update_msg", "your record NOT update "+id);
			}
			RequestDispatcher rd = request.getRequestDispatcher("update_msg.jsp");
			rd.forward(request, response);
		   
		
	}
	

}
