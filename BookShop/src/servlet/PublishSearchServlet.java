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

/**
 * Servlet implementation class PublishSraechServlet
 */
@WebServlet("/PublishSearchServlet")
public class PublishSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		if (keyword != null && !keyword.equals("")) {
			// int id = Integer.valueOf(nameStr);
			PublishDao dao = new PublishDao();	
			List<PublishSingle> publishlist = dao.selectPublish(keyword);
			request.setAttribute("publishlist", publishlist);
		//	request.setAttribute("publish", publish);
		}
	     request.getRequestDispatcher("./PublishShowServlet").forward(request, response);
	}

}
