<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gcweb.GoodsSingle"%>
<%@ page import="dbgc.db"%>
<%@page import="java.sql.*"%>
<jsp:useBean id="myCar" class="gcweb.ShopCar" scope="session" />
<%
	ArrayList goodlist = new ArrayList();
	PreparedStatement ps;
	db co = new db();
	int i = 0;
	ps = co.PreparedStatement("select * from book");
	ResultSet r = ps.executeQuery();
	while (r.next()) {
		GoodsSingle single = new GoodsSingle();
		single.setBookId(r.getString("BookId"));
		single.setBookName(r.getString("BookName"));
		single.setBookPrice(r.getInt("BookPrice"));
		single.setBookNum(1);
		single.setBookOthNum(r.getInt("BookNum"));
		single.setPublishName(r.getString("PublishName"));
		single.setBookPic(r.getString("BookPic"));
		goodlist.add(i,single);
		i++;
	}
%>
<%
	session.setAttribute("goodslist", goodlist);
	response.sendRedirect("buyshow.jsp");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>