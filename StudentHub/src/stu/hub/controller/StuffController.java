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

import stu.hub.pojo.User;
import stu.hub.util.MyDbUtil;

/**
 * Servlet implementation class StuffController
 */
@WebServlet("/StuffController")
public class StuffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuffController() {
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
HttpSession session = request.getSession(false);
		
		if(session.getAttribute("usr")!=null){
			
			User u = (User)session.getAttribute("usr");
			
			String item_name=request.getParameter("item_name");
			String otherItem = request.getParameter("other");
			String mob_no =request.getParameter("mob_no");
			
			Connection con = null;
			PreparedStatement pstmt = null;
			int rs=0,rs1=0,rs3=0;
			ResultSet rs2;
			int req_no=0;
			int sid=u.getSid();
			try{
				con=MyDbUtil.getConnection();
				String sql="INSERT INTO SH_U_REQ (REQ_NO,SID) VALUES ((select nvl(max(req_no),0)+1 from SH_U_REQ),?)";
				//		"INSERT INTO ROOM_REQ (REQ_NO,SID,REQ_TIME)VALUES((SELECT NVL(MAX(REQ_NO),0)+1 FROM ROOM_REQ),?,SYSDATE)";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1,sid);
				rs=pstmt.executeUpdate();
				if(rs!=0){
				String 	sql1="SELECT MAX(REQ_NO) FROM SH_U_REQ";
				pstmt=con.prepareStatement(sql1);
				rs2=pstmt.executeQuery();
				if(rs2.next()){
				req_no=	rs2.getInt(1);
				}
				
				String sql2="INSERT INTO STUFF_REQ(REQ_NO,SID,REQ_TIME) VALUES(?,?,SYSDATE)";
				pstmt=con.prepareStatement(sql2);
				pstmt.setInt(1,req_no);
				pstmt.setInt(2,sid);
				rs1=pstmt.executeUpdate();
				if(rs1!=0){
					
					
					String sql3="INSERT INTO STUFF_DETAIL(REQ_NO,SID,ITEM_NAME,OTHER,MOB_NO) VALUES (?,?,?,?,?)";

				//"INSERT INTO STUFF_DETAIL(STUFF_ID,REQ_NO,ITEM_NAME,ADDRESS,MOB_NO,PRICE) VALUES ((select nvl(max(STUFF_ID),0)+1 from STUFF_DETAIL),?,?,?,?,?)";
					pstmt=con.prepareStatement(sql3);
					pstmt.setInt(1, req_no);
					pstmt.setInt(2,sid);
					pstmt.setString(3, item_name);
					pstmt.setString(4, otherItem);
					pstmt.setString(5, mob_no);
			
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
			if(rs!=0&&rs1!=0) {
				String msg="Sucessfully submitted  with req no:"+req_no;
				session.setAttribute("lapreq", msg);
			}else {
				String msg = "Some Problem occured in request submission";
				session.setAttribute("lapreq", msg);
			}
			response.sendRedirect("lapsubmit.jsp");
			
		}//if session
		else{
			response.sendRedirect("login.jsp");

		}

	}

}
