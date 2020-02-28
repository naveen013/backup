package nit.com.controler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import nit.com.bo.Employe;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUploadControler extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 PrintWriter pw = response.getWriter();
		 InputStream ips = null;
		 File file = null;
		 String name = null;
		 String path = "C:/Users/user1/workspace2/ImageUpload/img";
		 
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 int isInsertrd;
		 
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
							
						}
                      }
                      
                      reName  =  "na_"+System.nanoTime()+(reName.substring(reName.indexOf(".")));
                      
                      file = new File(path,reName);
                      try {
                           item.write(file);						
					} catch (Exception e) {
                       e.printStackTrace();
					}
				}else {
					String paramName = item.getFieldName();
					if("name".equals(paramName))
						name = item.getString();
				} 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }try{
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			String sql = "insert into employe2 (name,photo) values (?,?)";
			pstmt  =con.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setBinaryStream(2,ips,(int)fileSize);
			isInsertrd = pstmt.executeUpdate();
			if(isInsertrd==1){
				pw.print("inserted");
			}
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
			}
			}finally{
				
				try {
					if(con!=null){
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}//try jdbc
         RequestDispatcher rd = null;
         //rd= request.getRequestDispatcher("view_image.jsp");
         rd.forward(request, response);
         
	}//doPost

}//ImageUploadControler
