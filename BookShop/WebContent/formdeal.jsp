<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dbgc.db"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="bean" class="ks.bean" scope="page"/>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:setProperty property="*" name="bean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("utf-8");
String username = request.getParameter("username");
String password = request.getParameter("userpwd");
db dbcon = new db();
try{
String sql = "insert into message values(?,?)";
PreparedStatement prestate = dbcon.PreparedStatement(sql);
prestate.setString(1, username);
prestate.setString(2, password);
prestate.executeQuery();}
catch(SQLException e) {
	System.out.println(e.toString());
}

response.sendRedirect("login.jsp");
%>
<body>
</body>
</html>