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
 * Servlet implementation class LaptopSellController
 */
@WebServlet("/LaptopSellController")
public class LaptopSellController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaptopSellController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("owner");
		String mob_no=request.getParameter("contact");
		String processor= request.getParameter("processor");
		String brandstr = request.getParameter("brand");
		String ramstr = request.getParameter("RAM");
		String hardwarestr = request.getParameter("Hardware");
		String pricestr = request.getParameter("price1");
		int price =Integer.parseInt(pricestr);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int order_no=0;
		int status=0;
		int status1=0;
		int status2=0;
		
		try {
			con = MyDbUtil.getConnection();
			
			String sql3 = "INSERT INTO seller(order_NO,name,mob_no) VALUES((SELECT NVL(MAX(order_NO),0)+1 from seller),?,?)";
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1,name);
			pstmt.setString(2,mob_no);
			status = pstmt.executeUpdate();
			
			if(status!=0){
				String 	sql1="SELECT MAX(order_NO) FROM seller";
				pstmt=con.prepareStatement(sql1);
				rs=pstmt.executeQuery();
				if(rs.next()){
				order_no=	rs.getInt(1);
				}
				String sql = "INSERT INTO laptop_sell_req(order_NO,REQ_TIME) VALUES(?,SYSDATE)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,order_no);
				status1 = pstmt.executeUpdate();
				if(status1!=0){
				String sql2="INSERT INTO LAPTOP_SELL_DETAIL (order_no,name,mob,BRAND,RAM,HARDWARE,PROCESSOR,PRICE) VALUES (?,?,?,?,?,?,?,?)";
					pstmt=con.prepareStatement(sql2);
					pstmt.setInt(1, order_no);
					pstmt.setString(2,name);
					pstmt.setString(3,mob_no);
					pstmt.setString(4,brandstr);
					pstmt.setString(5,ramstr);
					pstmt.setString(6,hardwarestr);
					pstmt.setString(7,processor);
					pstmt.setInt(8,price);
					status2=pstmt.executeUpdate();
				}//status1
			}//if
	
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
		if(status!=0 && status2!=0 &&status1!=0) {
			response.sendRedirect("message.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}

	}

}
