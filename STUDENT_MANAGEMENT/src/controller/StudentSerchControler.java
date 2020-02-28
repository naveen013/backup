package controller;

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

import sis.com.bo.Student;

public class StudentSerchControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = request.getParameter("stu_id");
		
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
			String sql = "select *from Student where StuId="+idStr;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				long id = rs.getLong("StuId");
				String name = rs.getString("StuName");
				String email = rs.getString("StuEmail");
				long branchId = rs.getLong("BranchId");
				foundStu = new Student();
				foundStu.setId(id);
				foundStu.setName(name);
				foundStu.setEmail(email);
				foundStu.setBrachId(branchId);
			}
		} catch (ClassNotFoundException e) {
          e.printStackTrace();			
		}catch (SQLException e) {
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
		RequestDispatcher rd  = null;

		if(foundStu==null){
		//not found
			String notFoundMsg = "There are no such employee exist for give id "+ idStr;
			request.setAttribute("not_found_msg", notFoundMsg); 
			rd  = request.getRequestDispatcher("stu_search.jsp");
		}else{
			//found 
			request.setAttribute("stu",foundStu);
			rd  = request.getRequestDispatcher("stu_search_result.jsp");
			
		}
		 

		rd.forward(request, response);
	}

}
