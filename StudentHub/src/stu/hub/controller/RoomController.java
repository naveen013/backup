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
 * Servlet implementation class RoomController
 */
@WebServlet("/RoomController")
public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("usr")!=null){
			
			User u = (User)session.getAttribute("usr");
			
			String adress=request.getParameter("addr");
			String mob=request.getParameter("contactNo");				

			String flat=request.getParameter("flat");
			String pricestr=request.getParameter("price");
			int price = Integer.parseInt(pricestr);
			
			
			
		//	int rent5 = Integer.parseInt(rent);
			
			Connection con=null;
			PreparedStatement pstmt =null;
			int sid = u.getSid();
			int rs=0,rs2=0,rs3=0;
			ResultSet rs1;
			int req_no=0;
		
			try{
				con=MyDbUtil.getConnection();
				String sql="INSERT INTO SH_U_REQ (REQ_NO,SID) VALUES ((select nvl(max(req_no	),0)+1 from SH_U_REQ),?)";
				//		"INSERT INTO ROOM_REQ (REQ_NO,SID,REQ_TIME)VALUES((SELECT NVL(MAX(REQ_NO),0)+1 FROM ROOM_REQ),?,SYSDATE)";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1,sid);
				rs=pstmt.executeUpdate();
				if(rs!=0){
					String 	sql1="SELECT MAX(REQ_NO) FROM SH_U_REQ";
					pstmt=con.prepareStatement(sql1);
					rs1=pstmt.executeQuery();
					if(rs1.next()){
						req_no=	rs1.getInt(1);
					}
				//System.out.println(req_no);
					String sql2="INSERT INTO ROOM_REQ (REQ_NO,SID,REQ_TIME) VALUES (?,?,SYSDATE)";
				//		"INSERT INTO ROOM_REQ (REQ_NO,SID,REQ_TIME)VALUES((SELECT NVL(MAX(REQ_NO),0)+1 FROM ROOM_REQ),?,SYSDATE)";
					pstmt= con.prepareStatement(sql2);
					pstmt.setInt(1,req_no);
					pstmt.setInt(2,sid);
					rs3=pstmt.executeUpdate();
					if(rs3!=0){
						String sql3="insert into room_detail (REQ_NO,SID,address,mob_no,accommodation,price_room)values (?,?,?,?,?,?)";
					//		"insert into room_detail (RID,REQ_NO,name,address,mob_no,no_of_room,price_room,price_flat1,price_flat2,price_flat3,price_flat4)values ((select nvl(max(RID),0)+1 from room_detail),?,?,?,?,?,?,?,?,?,?)";
						pstmt=con.prepareStatement(sql3);
				
						pstmt.setInt(1,req_no);
						pstmt.setInt(2,sid);
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
				String msg="Sucessfully submitted  with req no:"+req_no;
				session.setAttribute("lapreq", msg);
			}else {
				String msg = "Some Problem occured in request submission";
				session.setAttribute("lapreq", msg);
			}
			response.sendRedirect("lapsubmit.jsp");

			
		}//if session 
		else {
			response.sendRedirect("login.jsp");
		}//else
	}

}
