<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8 ">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
	<%
		request.setCharacterEncoding("UTF-8");
		String BookId = (String) session.getAttribute("bookid");
		String BookName = request.getParameter("BookName");
		String BookPic = request.getParameter("BookPic");
		String BookPrice = request.getParameter("BookPrice");
		String Author = request.getParameter("Author");
		String BookNum = request.getParameter("BookNum");
		String PubTime = request.getParameter("PubTime");
		String PublishName = request.getParameter("PublishName");
		String upsql = "update book set BookName='" + BookName + "',BookPic='" + BookPic + "',BookPrice='"
				+ BookPrice + "',Author='" + Author + "',BookNum='" + BookNum + "',PubTime='" + PubTime
				+ "',PublishName='" + PublishName + "'where BookId='" + BookId + "';";
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		int rs = stmt.executeUpdate(upsql);
		response.sendRedirect("test4.jsp");
	%>
</body>
</html>