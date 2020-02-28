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

import nit.com.bo.Branch;
import nit.com.bo.Student;

public class BranchSerchByBranchId extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	     
			String strBranchId = request.getParameter("BranchId");
			long branchId = Long.parseLong(strBranchId);
			
			Branch foundBranch = null;
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:XE";
				String user = "system";
				String password = "root";
				con = DriverManager.getConnection(url,user,password);
				stmt = con.createStatement();
				String sql = "select * from Branch where BranchId = "+branchId;
				rs = stmt.executeQuery(sql);
				  while (rs.next()) {
					  long id = rs.getLong("BranchId");
						String name = rs.getString("BranchName");
						String hod = rs.getString("Hod");
						
					    foundBranch = new Branch();
					    foundBranch.setId(id);
					    foundBranch.setName(name);
					    foundBranch.setHod(hod);

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
				
			}//end of finally
			   RequestDispatcher rd = null;
			   if (foundBranch==null) {
				   //not found
	           String notFoundMsg = "there are no such Branch exists for given name"+branchId;	
				request.setAttribute("not_found_msg", notFoundMsg); 
				rd  = request.getRequestDispatcher("stu_search.jsp");
			}else{
				//found 
				request.setAttribute("branch",foundBranch);
				rd  = request.getRequestDispatcher("Branch_search_result.jsp");
			}//end of else
			   rd.forward(request, response);
	}

}
