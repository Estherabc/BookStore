
<%@page import="dbgc.db"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="gcweb.GoodsSingle"%>
<jsp:useBean id="myCar" class="gcweb.ShopCar" scope="session" />
<%
	ArrayList buylist = myCar.getBuylist();
	float total = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chat</title>
</head>
<%
	int i = 0;
	PreparedStatement pst, psttt;
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	db con = new db();
	pst = con.PreparedStatement("select * from message where name=? and password=?");
	pst.setString(1, username);
	pst.setString(2, password);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
		db connn = new db();
		psttt = connn.PreparedStatement("select * from shopcar where username=? and testno=1");
		psttt.setString(1, username);
		ResultSet rrrr = psttt.executeQuery();
		if (rrrr.next()) {
			db connnn = new db();
			PreparedStatement t = connnn.PreparedStatement("select * from shopcar where testno=0");
			ResultSet s = t.executeQuery();
			while (s.next()) {
				ArrayList goods = new ArrayList();
				GoodsSingle single = new GoodsSingle();
				single.setBookId(s.getString("bookid"));
				single.setBookName(s.getString("bookname"));
				single.setBookNum(s.getInt("booknum"));
				single.setBookPic(s.getString("bookpic"));
				single.setBookPrice(s.getInt("bookprice"));
				single.setPublishName(s.getString("publishname"));
				goods.add(i, single);
				myCar.addItem(single);
			}
			response.sendRedirect("buyindex.jsp");
		} else {
			session.setAttribute("uname", username);
			db dbcon = new db();
			PreparedStatement ps = dbcon.PreparedStatement("select * from shopcar where username=? and testno=0");
			ps.setString(1, username);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ArrayList goodslist = new ArrayList();
				GoodsSingle single = new GoodsSingle();
				single.setBookId(r.getString("bookid"));
				single.setBookName(r.getString("bookname"));
				single.setBookNum(r.getInt("booknum"));
				single.setBookPic(r.getString("bookpic"));
				single.setBookPrice(r.getInt("bookprice"));
				single.setPublishName(r.getString("publishname"));
				goodslist.add(i, single);
				myCar.addItem(single);
			}
			ps = dbcon.PreparedStatement("select * from shopcar where username=? and testno=0");
			ps.setString(1, username);
			r = ps.executeQuery();
			while (r.next()) {
				db dbc = new db();

				try {
					PreparedStatement p = dbc.PreparedStatement("update shopcar set testno=1 where username=? ");
					p.setString(1, username);
					ResultSet rr = p.executeQuery();
				} catch (Exception e) {
					e.getStackTrace();
				}
			}

			response.sendRedirect("buyindex.jsp");
		}
	} else {
		response.sendRedirect("buylogin.html");
	}
	session.setAttribute("username", username);
%>
<body>
</body>
</html>