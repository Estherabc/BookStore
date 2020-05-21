package servlet;

import javax.servlet.http.HttpServlet;

import dao.PublishDao;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/PublishDelectServlet")
public class PublishDelectServlet extends HttpServlet { // É¾³ýÊý¾Ý

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameStr = request.getParameter("publishName");
		if (nameStr != null && !nameStr.equals("")) {
			//String name = String.valueOf(nameStr);
			PublishDao dao = new PublishDao();
			dao.deletePublish(nameStr);
		}
		request.getRequestDispatcher("./PublishShowSErvlet").forward(request, response);
	}

}
