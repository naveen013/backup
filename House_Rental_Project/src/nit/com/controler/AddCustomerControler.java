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
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AddCustomerControler extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		// String name = request.getParameter("username");
		 //System.out.println("name="+name);
		 String name = null;
		 String password = null;
		 String email = null;
         String gender = null;
		 String mobile = null;
		 String address = null;
		 String imgName = null;
		 
		 
        PrintWriter pw = response.getWriter();
		 InputStream ips = null;
		// File file = null;
		 String name1 = null;
		 
		 String path = "C:/Users/user1/workspace2/House_Rental_Project/WebContent/image/8.jpg";
		 
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet  resultSet = null;
		 int isInsertrd = 0;
		 
		 long fileSize = 0;
		 int maxSize = 1024*5000;
		 int maxFactSize = 3024*5000;
		 String type = request.getContentType();
		 System.out.println("type="+type);
		 
		if (type.indexOf("multipart/form-data")>=0){
			
			 DiskFileItemFactory diskFactory = new DiskFileItemFactory();
			 diskFactory.setSizeThreshold(maxFactSize);
			File file1=new File("E:\temp2");
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
	                     
	                     if (!reName.isEmpty()) {
	                     String mimeType = getServletContext().getMimeType(reName);
	                     if (!mimeType.startsWith("image/")) {
	                   		  pw.print("error");
	                       return;
						}
					}
	                     reName  =  "na_"+System.nanoTime()+(reName.substring(reName.indexOf(".")));
	                    // file = new File(path,reName);
	                 //  try {
	                          //item.write(file);
					//} catch (Exception e) {
						//e.printStackTrace();
					//}  
					
				}else {
					String paramName = item.getFieldName();
					if("img_name".equals(paramName))
						imgName = item.getString();
					if("username".equals(paramName))
						name = item.getString();
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


				}
			 }
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "system";
					String password1 = "root";
					con = DriverManager.getConnection(url,user,password1);
		    String sql = "insert into customer(username,password,email,mobile,gender,address,img_name,photo) values(?,?,?,?,?,?,?,?)";
					pstmt  =con.prepareStatement(sql);	
					//Integer bedroom =Integer.parseInt("bedRoom");
					//long mobile1 = Long.parseLong("moobile");
					pstmt.setString(1, name);
					pstmt.setString(2, password);
					pstmt.setString(3, email);
					pstmt.setString(4, mobile);
					pstmt.setString(5, gender);
					pstmt.setString(6, address);
					pstmt.setString(7, imgName);
					pstmt.setBinaryStream(8,ips,(int)fileSize);
				    isInsertrd = pstmt.executeUpdate();
				    //System.out.println(isInsertrd);
					//System.out.println("bed="+bedroom);
					
					
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
				}
			}

			System.out.println("welcome");
		}//end of if
		
		if (isInsertrd == 1) {
			request.setAttribute("message", "customer added Successfully :"+name);
		}else{
			request.setAttribute("message", "customer not added :"+name);
		}
		RequestDispatcher rd = request.getRequestDispatcher("cust_reg_msg.jsp");
		rd.forward(request, response);	

	}
}
