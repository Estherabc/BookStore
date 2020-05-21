package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.WordDao;
import valuebean.PublishSingle;
import valuebean.WordSingle;

/**
 * Servlet implementation class WordShowServlet
 */
@WebServlet("/WordShowServlet")
public class WordShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WordDao dao = new WordDao();
		List<WordSingle> wordlist = dao.getAllwords();
		req.setAttribute("wordlist", wordlist);
		req.getRequestDispatcher("showwords.jsp").forward(req, resp);
	}

}
