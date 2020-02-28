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

public class AddBranch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String StrbranchId = request.getParameter("BranchId");
		String branchName = request.getParameter("BranchName");
		String hod = request.getParameter("Hod");
		
		long  branchId = Long.parseLong(StrbranchId); 
		
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   int resultSet = 0;
		   try {
		         Class.forName("oracle.jdbc.driver.OracleDriver");
		         String url="Jdbc:oracle:thin:@localhost:1521:XE";
		         String user = "system";
		         String password = "root";
		         con = DriverManager.getConnection(url,user,password);
		         String sql = " insert into Branch(BranchId,BranchName,Hod) values(?,?,?)";
		         pstmt = con.prepareStatement(sql);
		         
		         pstmt.setLong(1,branchId);
		         pstmt.setString(2, branchName);
		         pstmt.setString(3, hod);
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
				request.setAttribute("insert_message", "Record inserted"+branchId);
			}else{
				request.setAttribute("insert_message", "Record not inserted"+branchId);
			}
			RequestDispatcher rd = request.getRequestDispatcher("add_branch_msg.jsp");
			rd.forward(request, response);
		
	}

}
