package chat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import chat.MyTools;
import chat.WordSingle;
public class WordServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String author=MyTools.toChinese(request.getParameter("userName"));
		String no=MyTools.toChinese(request.getParameter("userId"));
		String content=MyTools.toChinese(request.getParameter("content"));
		String today=MyTools.changeTime(new Date());
		WordSingle single=new WordSingle();
		single.setUserName(MyTools.changeHTML(author)); 
		single.setUserId(MyTools.changeHTML(no));
		single.setContent(content);
		single.setTime(today);
		HttpSession session=request.getSession();
		ServletContext scx=session.getServletContext();
		ArrayList wordlist=(ArrayList)scx.getAttribute("wordlist");
		if(wordlist==null)
			wordlist=new ArrayList();
		wordlist.add(single);
		scx.setAttribute("wordlist", wordlist);
		response.sendRedirect("ChatShow.jsp");
	}

}
