package nit.com.controler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ViewOwnerControler extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String idstr =null;
		   String userName=null;
			String password =null;
			String email =null;
			String mobile = null;
			String gender = null;
			String address =null; 
			String name=null;
			long id=0;
			
         PrintWriter pw = response.getWriter();
		 InputStream ips = null;
		 File file = null;
		 String name1 = null;
		 String path = "C:/Users/user1/workspace2/House_Rental_Project/img";
		 
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet  resultSet = null;
		 int isInsertrd = 0;
		 
		 long fileSize = 0;
		 int maxSize = 1024*5000;
		 int maxFactSize = 3024*5000;
		 String type = request.getContentType();
		 
		 if(type.indexOf("multipart/form-data")>=0){
			 DiskFileItemFactory diskFactory = new DiskFileItemFactory();
			 diskFactory.setSizeThreshold(maxFactSize);
			File file1=new File("E:\temp1");
			 diskFactory.setRepository(file1);
			ServletFileUpload upload = new ServletFileUpload(diskFactory);
			 upload.setSizeMax(maxSize);
			 
			 try {
				String reName = null;
				List list = upload.parseRequest(request);
				Iterator itr = list.iterator();
				FileItem item = null;
				
				while (itr.hasNext()) {
                
					item = (FileItem)itr.next();
					if (!item.isFormField()) {
                     reName = item.getName();
                     fileSize = item.getSize();
                     ips = item.getInputStream();//getting image or file
                     if(!reName.isEmpty()){
                   	  String mimeType = getServletContext().getMimeType(reName);
                   	  if (!mimeType.startsWith("image/")) {
                   		  pw.print("error");
                     return;	
						}//!mimeType close
                     }//!reName close
                     reName  =  "na_"+System.nanoTime()+(reName.substring(reName.indexOf(".")));
                     file = new File(path,reName);
                     try {
                          item.write(file);						
					} catch (Exception e) {
                      e.printStackTrace();
					}
				}else {
					String paramName = item.getFieldName();
					if("img_name".equals(paramName))
						name = item.getString();
					if("username".equals(paramName))
						userName = item.getString();
					if("userid".equals(paramName)){
						idstr = item.getString();
					}
					if("password".equals(paramName))
						password = item.getString();
					if("email".equals(paramName))
						email = item.getString();
					if("mobile".equals(paramName))
						mobile = item.getString();
					if("gender".equals(paramName))
						gender = item.getString();
					if("address".equals(paramName))
						address = item.getString();

					
				}// !item.isFormField()
				}//while close
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "system";
				String password1 = "root";
				con = DriverManager.getConnection(url,user,password1);
				String sql = "insert into owner(USERID,username,mobile,password,email,gender,address,img_name,photo) values(?,?,?,?,?,?,?,?,?)";
				pstmt  =con.prepareStatement(sql);
                 pstmt.setString(1,idstr);
		         pstmt.setString(2,userName);
		         pstmt.setString(3,mobile);
		         pstmt.setString(4,password);
		         pstmt.setString(5,email);
		         pstmt.setString(6,gender);
		         pstmt.setString(7,address);
				 pstmt.setString(8,name);
				 pstmt.setBinaryStream(9,ips,(int)fileSize);
				 isInsertrd = pstmt.executeUpdate();
					System.out.println(isInsertrd);
				
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				} catch (SQLException e) {
						e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						if(con!=null){
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}//	Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 }//type.indexOf("multipart/form-data") close
			System.out.println(isInsertrd);
			if (isInsertrd == 1) {
				request.setAttribute("regestration_message", "owner regesterd "+userName);
			}else{
				request.setAttribute("regestration_message", "owner not regesterd "+userName);
			}
			RequestDispatcher rd = request.getRequestDispatcher("reg_owner_msg.jsp");
			rd.forward(request, response);
	}//end of main

	}//end of class
		/*String idstr = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		
		long id = Long.parseLong(idstr);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int resultSet = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url="Jdbc:oracle:thin:@localhost:1521:XE";
	         String user = "system";
	         String dbpassword = "root";
	         con = DriverManager.getConnection(url,user,dbpassword);
	         String sql = " insert into owner(userid,username,mobile,password,email,gender,address) values(?,?,?,?,?,?,?)";
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setLong(1,id);
	         pstmt.setString(2, username);
	         pstmt.setString(3, mobile);
	         pstmt.setString(4, password);
	         pstmt.setString(5, email);
	         pstmt.setString(6, gender);
	         pstmt.setString(7, address);
	        resultSet =  pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
          e.printStackTrace();
		}catch (SQLException e) {
              e.printStackTrace();
		}catch (Exception e) {
             e.printStackTrace();
		}finally{
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//end of finally
		System.out.println(resultSet);
		if (resultSet == 1) {
			request.setAttribute("regestration_message", "owner regesterd "+username);
		}else{
			request.setAttribute("regestration_message", "owner not regesterd "+username);
		}
		RequestDispatcher rd = request.getRequestDispatcher("reg_owner_msg.jsp");
		rd.forward(request, response);*/

	