package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublishDao;
import dao.WordDao;
import valuebean.PublishSingle;
import valuebean.WordSingle;


@WebServlet("/WordSearchServlet")
public class WordSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WordSearchServlet() {
        super();      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		if (keyword != null && !keyword.equals("")) {
			WordDao dao = new WordDao();	
			List<WordSingle> wordlist = dao.selectWord(keyword);
			request.setAttribute("wordlist", wordlist);
		}
	     request.getRequestDispatcher("wordhouse.jsp").forward(request, response);
	
	}

}
