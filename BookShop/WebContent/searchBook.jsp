<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书搜索</title>
<style type="text/css">
body {
	background-image: url(./images/13.jpg);
	background-size: cover;
}
</style>
</head>
<body>
	<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
	<%
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		Connection con = db.getConnection();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String seasql = "select * from book where BookId like'%" + search + "%' or BookName like'%" + search
				+ "%' or PublishName like'%" + search + "%' or Author like'%" + search + "%'  or BookType like'%"
				+ search + "%'";
		ResultSet rs = stmt.executeQuery(seasql);
		%>
		查询图书信息为<%=search%>
		
		<% 
		while (rs.next()) {
			String upd = null, del = null;
			upd = "<a href=bookUpdate.jsp?BookId=" + rs.getString("BookId") + ">修改</a>";
			del = "<a href=bookDelete.jsp?BookId=" + rs.getString("BookId") + ">删除</a>";
	%>
	<table>
		<tr align="center" height="30" bgcolor="lightgrey">
			<td>图书编号</td>
			<td>图书名</td>
			<td>图书图片</td>
			<td>图书价格</td>
			<td>作者</td>
			<td>图书数量</td>
			<td>图书种类</td>
			<td>出版时间</td>
			<td>出版社名称</td>
			<td colspan="2">操作</td>
		</tr>
		<tr>
			<td><%=rs.getString("BookId")%></td>
			<td><%=rs.getString("BookName")%></td>
			<td><img width=80 height=100 src="<%=rs.getString("BookPic")%>">
			<td><%=rs.getString("BookPrice")%></td>
			<td><%=rs.getString("Author")%></td>
			<td><%=rs.getString("BookNum")%></td>
			<td><%=rs.getString("BookType")%></td>
			<td><%=rs.getString("PubTime")%></td>
			<td><%=rs.getString("PublishName")%></td>
			<td><%=upd%></td>
			<td><%=del%></td>
		</tr>
	</table>
	<%	
		} 
		rs.close();
		stmt.close();
	%>
</body>
</html>