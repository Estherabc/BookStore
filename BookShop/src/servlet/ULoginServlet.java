package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.db;

public class ULoginServlet extends HttpServlet {
	public ULoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String upwd = request.getParameter("password");
		String sql = "select * from bookstore.dbo.[user] where username = '" + uname + "'and password='" + upwd + "'";
		HttpSession session = request.getSession();
		db db=new db();
		try {
			ResultSet rs = db.executeQuery(sql);
			if (rs.next()) {
				session.setAttribute("loginUsername", uname);
				session.setAttribute("password", upwd);
				response.sendRedirect("test3.jsp");
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