package stu.hub.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stu.hub.util.MyDbUtil;

/**
 * Servlet implementation class RoomOwnerController
 */
@WebServlet("/RoomOwnerController")
public class RoomOwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
	//	if(session.getAttribute("usr")!=null){
			
		//	User u = (User)session.getAttribute("usr");
			
			String name=request.getParameter("name");
			String adress=request.getParameter("addr");
			String mob=request.getParameter("contactNo");				

			String flat=request.getParameter("flat");
			String pricestr=request.getParameter("rent");
			int price = Integer.parseInt(pricestr);
			
			
			
		//	int rent5 = Integer.parseInt(rent);
			
			Connection con=null;
			PreparedStatement pstmt =null;
		//	int sid = u.getSid();
			int rs=0,rs2=0,rs3=0;
			ResultSet rs1;
			int order_no=0;
		
			try{
				con=MyDbUtil.getConnection();
				/*
				 * order_no number(5) primary key,
	name varchar2(20),
	mob_no varchar(10)
);

INSERT INTO seller (order_no,name,mob_no) VALUES ((SELECT NVL(MAX(order_no),0)+1 FROM seller),'raj','287y4922');
*/
				String sql="INSERT INTO seller (order_no,name,mob_no) VALUES ((SELECT NVL(MAX(order_no),0)+1 FROM seller),?,?)";
	
				pstmt= con.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,mob);
				rs=pstmt.executeUpdate();
				if(rs!=0){
					String 	sql1="SELECT MAX(order_no) FROM seller";
					pstmt=con.prepareStatement(sql1);
					rs1=pstmt.executeQuery();
					if(rs1.next()){
						order_no=	rs1.getInt(1);
					}
					String sql2="INSERT INTO ROOM_SELL_REQ (order_no,REQ_TIME) VALUES (?,SYSDATE)";
					pstmt= con.prepareStatement(sql2);
					pstmt.setInt(1,order_no);
	
					rs3=pstmt.executeUpdate();
					if(rs3!=0){
						String sql3="insert into room_sell_detail (order_no,name,address,mob_no,accommodation,price_room)values (?,?,?,?,?,?)";
						pstmt=con.prepareStatement(sql3);
				
						pstmt.setInt(1,order_no);
						pstmt.setString(2,name);
						pstmt.setString(3,adress);
						pstmt.setString(4,mob);
						pstmt.setString(5,flat);
						pstmt.setInt(6,price);
					
						rs2=pstmt.executeUpdate();
					
				}//rs3
			}//rs
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}//if
			}//finally
			if(rs!=0&&rs2!=0 && rs3!=0) {
				response.sendRedirect("message.jsp");
				//String msg="Sucessfully submitted  with req no:"+req_no;
			//	session.setAttribute("lapreq", msg);
			}else {
				//String msg = "Some Problem occured in request submission";
				//session.setAttribute("lapreq", msg);
				response.sendRedirect("error.jsp");
			}
	//		response.sendRedirect("message.jsp");
			

			
		/*}//if session 
		else {
			response.sendRedirect("login.jsp");
		}//else*/
	}

}
