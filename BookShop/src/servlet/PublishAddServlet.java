package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PublishDao;
import valuebean.PublishSingle;


@WebServlet("/PublishAddServlet")
public class PublishAddServlet extends HttpServlet { // Ìí¼ÓÊý¾Ý
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	 request.getRequestDispatcher("pulishadd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String publishName = request.getParameter("publishName");
		String publishPlace = request.getParameter("publishPlace");
		String PublishNumber= request.getParameter("publishNumber");
		String insertDate=request.getParameter("insertDate");
		String books=request.getParameter("books");
		PublishSingle publish = new PublishSingle();
		publish.setPublishName(new String(publishName.getBytes("ISO-8859-1"), "UTF-8")); 
		publish.setPublishPlace(new String(publishPlace.getBytes("ISO-8859-1"), "UTF-8"));
		publish.setPublishNumber(new String(PublishNumber.getBytes("ISO-8859-1"), "UTF-8"));
		publish.setInsertDate(new String(insertDate.getBytes("ISO-8859-1"), "UTF-8"));
		publish.setBooks(new String(books.getBytes("ISO-8859-1"), "UTF-8"));
		PublishDao dao = new PublishDao();
		dao.addPublish(publish);
		request.getRequestDispatcher("addsuccess.html ").forward(request, response);
	}
}
