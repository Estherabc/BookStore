package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.db;

public class CLoginServlet extends HttpServlet {
	public CLoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("username");
		String cpwd = request.getParameter("password");
		String sql = "select * from bookstore.dbo.[client] where username = '" + cname + "'and password='" + cpwd + "'";
		HttpSession session = request.getSession();
		db db=new db();
		try {
			ResultSet rs = db.executeQuery(sql);
			if (rs.next()) {
				session.setAttribute("loginUsername", cname);
				session.setAttribute("password", cpwd);
				response.sendRedirect("test.jsp");
			} else {
				response.sendRedirect("test2.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void init() throws ServletException{
		
	}
	
}
