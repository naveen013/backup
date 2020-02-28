package stu.hub.controller;

import java.io.IOException;

import java.io.PrintWriter;
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
 * Servlet implementation class LaptopReqController
 */
@WebServlet("/LaptopReqController")
public class LaptopReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaptopReqController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session.getAttribute("usr")!=null) {
			User u = (User)session.getAttribute("usr");
			String qty = request.getParameter("qnty");
			int quantity = Integer.parseInt(qty);
			Connection conn = null;
			PreparedStatement pstat = null;
			ResultSet rs = null;
			int reqno=0;
			int status=0;//status of inserting entry in table sh_u_req
			int status2=0;//status of inserting entry in table lap_req
			int status3=0;//status of inserting entry in table lap_details
			int sid = u.getSid();
			try {
				conn = MyDbUtil.getConnection();
				String sql = "INSERT INTO SH_U_REQ VALUES((SELECT NVL(MAX(REQ_NO),0)+1 FROM SH_U_REQ),?)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1,sid);
				status = pstat.executeUpdate();
				if(status!=0) {
					String sql2 = "SELECT MAX(REQ_NO) FROM SH_U_REQ";
					pstat=conn.prepareStatement(sql2);
					rs = pstat.executeQuery();
					if(rs.next()) {
						reqno = rs.getInt(1);
					}//if reqno
					System.out.println("reqno mil gaya");
					String sql3 = "INSERT INTO LAP_REQ VALUES(?,?,sysdate)";
					pstat = conn.prepareStatement(sql3);
					pstat.setInt(1,reqno);
					pstat.setInt(2,quantity);
					status2 = pstat.executeUpdate();
					System.out.println("status2 update ho gaya");
					
					for(int i=1;i<=quantity;i++) {
						String brand = request.getParameter("model"+i);
						String prob = request.getParameter("prob"+i);
						String desc = request.getParameter("desc"+i);
						String stat = "Request Accepted";
						String sql4 = "INSERT INTO LAP_DETAILS VALUES((SELECT NVL(MAX(SNO),0)+1 FROM LAP_DETAILS),?,?,?,?,?,?)";
						pstat = conn.prepareStatement(sql4);
						pstat.setInt(1, reqno);
						pstat.setInt(2, sid);
						pstat.setString(3, brand);
						pstat.setString(4, prob);
						pstat.setString(5, desc);
						pstat.setString(6, stat);
						status3 = pstat.executeUpdate();
						System.out.println("status3 update ho gaya");
					}//for
				}//status
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}//if
			
			}//finally
			if(reqno!=0&&(status2!=0)&&(status3!=0)) {
				String msg="Sucessfully submitted  with req no:"+reqno;
				session.setAttribute("lapreq", msg);
			}else {
				String msg = "Some Problem occured in request submission";
				session.setAttribute("lapreq", msg);
			}
			response.sendRedirect("lapsubmit.jsp");
		
		}//if session is on
		
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
