package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PublishDao;
import valuebean.PublishSingle;

@WebServlet("/PublishUpdateServlet")
public class PublishUpdateServlet extends HttpServlet { // 修改
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		String nameStr = request.getParameter("publishNmae");
		if (nameStr != null && !nameStr.equals("")) {
			// int id = Integer.valueOf(nameStr);
			PublishDao dao = new PublishDao();
			PublishSingle publish = dao.selectPublishByName(nameStr);
			request.setAttribute("publish", publish);
		}
		request.getRequestDispatcher("publishupdate.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // 根据此ID对数据的值进行修改
		String publishName = request.getParameter("publishNmae");
		String publishPlace = request.getParameter("publishPlace");
		String publishNumber = request.getParameter("publishNumber");
		String insertDate = request.getParameter("insertDate");
		String books = request.getParameter("books");
		PublishSingle publish = new PublishSingle();
		publish.setPublishName(new String(publishName.getBytes("ISO-8859-1"), "UTF-8"));
		publish.setPublishPlace(new String(publishPlace.getBytes("ISO-8859-1"), "UTF-8"));
		publish.setPublishNumber(new String(publishNumber.getBytes("ISO-8859-1"), "UTF-8"));
		publish.setInsertDate(new String(insertDate.getBytes("ISO-8859-1"), "UTF-8"));
		publish.setBooks(new String(books.getBytes("ISO-8859-1"), "UTF-8"));
		PublishDao dao = new PublishDao();
		dao.updatePublish(publish);
		request.getRequestDispatcher("updatesuccess.html").forward(request, response);
	}

}
