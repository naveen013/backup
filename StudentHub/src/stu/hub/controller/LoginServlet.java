package stu.hub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stu.hub.pojo.User;
import stu.hub.util.MyDbUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		System.out.println("Control aaaaaaa gya");
		String login_id = request.getParameter("user_name");
		System.out.println(login_id);
		String pass = request.getParameter("password");
		if(login_id.isEmpty()||pass.isEmpty()) {
			String emptymsg = "Login_id and password should be non empty";
			request.setAttribute("empty", emptymsg);
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else {
		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		User obj = null;
		
		try {
			con = MyDbUtil.getConnection();
			String sql = "SELECT * FROM SH_USER WHERE LOGIN_ID=? AND PASSWORD=?";
			pstat = con.prepareStatement(sql);
			pstat.setString(1, login_id);
			pstat.setString(2, pass);
			rs = pstat.executeQuery();
			if(rs.next()) {
				int sid = rs.getInt(1);
				String name = rs.getString("NAME");
				String uid = rs.getString("LOGIN_ID");
				String g = rs.getString("GENDER");
				String email = rs.getString("EMAIL_ID");
				String p = rs.getString("Password");
				String co = rs.getString("CONTACT");
				String course=rs.getString("COURSE");
				String add = rs.getString("ADDRESS");
				String inst = rs.getString("INSTITUTE");
				 int yoa=rs.getInt("YEAR_OF_ADMISSION");
				obj = new User(sid,name,uid,g,email,p,co,add,inst,course,yoa);
				System.out.println("object created in loginservlet");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//if
		}//finally
		
		if(obj!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("usr", obj);
			response.sendRedirect("Home.jsp");
			
		}else {
			request.setAttribute("forgot", "incorrect loginid or password");
			request.setAttribute("invalid",login_id );
			request.setAttribute("invalpss",pass );
			System.out.println("forgot pass");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
		}//if all details were filled
		
	}//doPost

}//class
