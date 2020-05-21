package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublishDao;
import valuebean.PublishSingle;
@WebServlet("/PublishShowServlet")
public class PublishShowServlet extends HttpServlet { // 显示全部数据

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PublishDao dao = new PublishDao();
		List<PublishSingle> publishlist = dao.getAllPublish();
		request.setAttribute("publishlist", publishlist);
		request.getRequestDispatcher("publishhouse.jsp").forward(request, response);
	}
}