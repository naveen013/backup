package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.Branch;

public class BranchControler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Branch>list = new ArrayList<Branch>();
		
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
			String sql = "select * from Branch";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				long id = rs.getLong("BranchId");
				String name = rs.getString("BranchName");
				String hod = rs.getString("Hod");
				
				Branch branch = new Branch();
				
				branch.setId(id);
				branch.setName(name);
                branch.setHod(hod);
                list.add(branch);
                
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
	      	request.setAttribute("branchlist", list);
	      	RequestDispatcher rd = null;
	      	rd = request.getRequestDispatcher("branch_view.jsp");
	      	rd.forward(request, response);
	}
}
