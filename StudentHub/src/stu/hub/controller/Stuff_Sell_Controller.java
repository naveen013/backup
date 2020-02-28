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

import stu.hub.util.MyDbUtil;

/**
 * Servlet implementation class Stuff_Sell_Controller
 */
@WebServlet("/Stuff_Sell_Controller")
public class Stuff_Sell_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stuff_Sell_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("owner");
		String item_name=request.getParameter("item_name");
		String otherItem = request.getParameter("other");
		String mob_no =request.getParameter("mobile");
		String priceStr =request.getParameter("price1");
		int price = Integer.parseInt(priceStr);
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs=0,rs1=0,rs3=0;
		ResultSet rs2;
		int order_no=0;
	
		try{
			con=MyDbUtil.getConnection();
		
		
			String sql="INSERT INTO seller (order_no,name,mob_no) VALUES ((select nvl(max(order_no),0)+1 from seller),?,?)";
			//		"INSERT INTO ROOM_REQ (REQ_NO,SID,REQ_TIME)VALUES((SELECT NVL(MAX(REQ_NO),0)+1 FROM ROOM_REQ),?,SYSDATE)";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,mob_no);
			rs=pstmt.executeUpdate();
			if(rs!=0){
				String 	sql1="SELECT MAX(ORDER_NO) FROM SELLER";
				pstmt=con.prepareStatement(sql1);
				rs2=pstmt.executeQuery();
				if(rs2.next()){
				order_no=	rs2.getInt(1);
				}
				
			String sql2="INSERT INTO STUFF_SELL_REQ(order_no,REQ_TIME) VALUES(?,SYSDATE)";
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1,order_no);
			rs1=pstmt.executeUpdate();
			if(rs1!=0){
				
				
				String sql3="INSERT INTO STUFF_SELL_DETAIL(order_no,name,mob_no,ITEM_NAME,OTHER,PRICE) VALUES (?,?,?,?,?,?)";

			//"INSERT INTO STUFF_DETAIL(STUFF_ID,REQ_NO,ITEM_NAME,ADDRESS,MOB_NO,PRICE) VALUES ((select nvl(max(STUFF_ID),0)+1 from STUFF_DETAIL),?,?,?,?,?)";
				pstmt=con.prepareStatement(sql3);
				pstmt.setInt(1,order_no);
				pstmt.setString(2,name);
				pstmt.setString(3, mob_no);
				pstmt.setString(4, item_name);
				pstmt.setString(5, otherItem);
				pstmt.setInt(6, price);
				
				rs3=pstmt.executeUpdate();
			}
		}//rs
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		if(rs!=0&&rs1!=0 && rs3!=0) {
			response.sendRedirect("message.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}
		}
}
