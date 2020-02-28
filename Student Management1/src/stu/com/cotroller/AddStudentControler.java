package stu.com.cotroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

		   String IdStr = request.getParameter("id");
		   String FirstName = request.getParameter("first_name");
		   String LastName = request.getParameter("last_name");
		   String Sex = request.getParameter("sex");
		   String BirthDateStr= request.getParameter("birthdate");
		   String Phone = request.getParameter("phone");
		   String Address = request.getParameter("Address");
		   
		   long Id = Long.parseLong(IdStr);	
		   
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
	         String sql = " insert into Students(id,first_name,last_name,sex,birthdate,phone,Address)  values(?,?,?,?,?,?,?)";
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setLong(1,Id);
	         pstmt.setString(2, FirstName);
	         pstmt.setString(3, LastName);
	         pstmt.setString(4, Sex);
	       //  pstmt.setString(5, BirthDate);
	         Date d1=Date.valueOf(BirthDateStr);
			pstmt.setDate(5, d1);
	         pstmt.setString(6, Phone);
	         pstmt.setString(7, Address);
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
			request.setAttribute("insert_message", "Record inserted "+FirstName);
		}else{
			request.setAttribute("insert_message", "Record not inserted "+FirstName);
		}
		RequestDispatcher rd = request.getRequestDispatcher("add_stu_msg.jsp");
		rd.forward(request, response);
		
	}

}
