<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除图书记录</title>
</head>
<body>
<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
	<%
		request.setCharacterEncoding("UTF-8");
	    String BookId=request.getParameter("BookId");
	    String delsql="delete from book where BookId='"+BookId+"';";
	    Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		int rs = stmt.executeUpdate(delsql);
		response.sendRedirect("test.jsp");
	%>
</body>
</html>