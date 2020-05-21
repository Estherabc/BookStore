<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="toolbean.MyTools"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书入库更新</title>
</head>
<body>
	<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String BookId = request.getParameter("BookId");
		String BookName = request.getParameter("BookName");
		String BookPic = request.getParameter("BookPic");
		int BookPrice = MyTools.strToint(request.getParameter("BookPrice"));
		String Author = request.getParameter("Author");
		int BookNum =MyTools.strToint(request.getParameter("BookNum"));
		String BookType = request.getParameter("BookType");
		String PubTime = request.getParameter("PubTime");
		String PublishName = request.getParameter("PublishName");
		String intsql = "insert into book values('" + BookId + "','" + BookName + "','" + BookPic + "','"
				+ BookPrice + "','" + Author + "','" + BookNum + "','" + BookType + "','" + PubTime + "','"
				+ PublishName + "');";
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		int rs = stmt.executeUpdate(intsql);
		response.sendRedirect("test4.jsp");
	%>
</body>
</html>