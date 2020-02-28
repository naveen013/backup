package controller;

import java.io.File;
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
import javax.swing.JFileChooser;

import sis.com.bo.Student;

public class StudentControler extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Student>list = new ArrayList<Student>();
		
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
			String sql = "select *from Student";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				long id = rs.getLong("StuId");
				String name = rs.getString("StuName");
				String email = rs.getString("StuEmail");
				long branchId = rs.getLong("BranchId");
				
				Student stu = new Student();
				stu.setId(id);
				stu.setName(name);
				stu.setEmail(email);
				stu.setBrachId(branchId);
				list.add(stu);
				
			}
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
              request.setAttribute("stulist", list);
              RequestDispatcher rd = null;
              rd= request.getRequestDispatcher("student_view.jsp");
              rd.forward(request, response);
              
	}

}
