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
 * Servlet implementation class BookSellController
 */
@WebServlet("/BookSellController")
public class BookSellController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSellController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("owner");
		String email=request.getParameter("email");
		String mob_no =request.getParameter("contact");
		String booktype =request.getParameter("btype");
		String bookname =request.getParameter("bname");
		String author=request.getParameter("aname");
		String priceStr =request.getParameter("price");
		int price = Integer.parseInt(priceStr);
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs=0;
	
		try{
			con=MyDbUtil.getConnection();
			String sql="INSERT INTO BOOK_SELLER_DETAIL(BOOK_NO,OWNER,CONTACT,EMAIL_ID,BOOK_TYPE,BOOK_NAME,BOOK_AUTHOR,SELL_PRICE,STATUS,SUBMIT_TIME)"+
			" VALUES ((select nvl(max(book_no),0)+1 from book_seller_detail),?,?,?,?,?,?,?,?,SYSDATE)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,mob_no);
				pstmt.setString(3, email);
				pstmt.setString(4, booktype);
				pstmt.setString(5, bookname);
				pstmt.setString(6, author);
				pstmt.setInt(7, price);
				pstmt.setString(8,"RequestAccepted");
				rs=pstmt.executeUpdate();
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
		if(rs!=0) {
			response.sendRedirect("message.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}

	}

}
