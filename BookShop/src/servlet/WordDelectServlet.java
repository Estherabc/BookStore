package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublishDao;

@WebServlet("/WordDelectServlet")
public class WordDelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("userId");
		if (idStr != null && !idStr.equals("")) {
			PublishDao dao = new PublishDao();
			dao.deletePublish(idStr);
		}
		request.getRequestDispatcher("./WordShowSErvlet").forward(request, response);
	}


}
