<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gcweb.GoodsSingle"%>
<%@ page import="gcweb.MyTools"%>
<%@page import="java.sql.*"%>
<%@ page import="dbgc.db"%>
<style type="text/css">
body {
	background-image: url(./images/13.jpg);
	background-size: cover;
}
</style>
<<jsp:useBean id="myCar" class="gcweb.ShopCar" scope="session" />
<%
	ArrayList buylist = myCar.getBuylist();
	float total = 0;
	request.setCharacterEncoding("utf-8");
	String username =(String)session.getAttribute("username"); 
	String action = request.getParameter("action");
	if (action == null)
		action = "";
	if (action.equals("buy")) {
		db dbcon=new db();
		ArrayList goodslist = (ArrayList) session.getAttribute("goodslist");
		int id = MyTools.strToint(request.getParameter("id"))-1;
		String bid=String.valueOf(id);
		GoodsSingle single = (GoodsSingle) goodslist.get(id);
		myCar.addItem(single);
		try{ 
		String sql = "update book set BookNum=BookNum-1 where BookId=?";
		PreparedStatement pst = dbcon.PreparedStatement(sql);
		pst.setString(1,bid);
		pst.executeQuery();}
		catch(SQLException e) {
			System.out.println(e.toString());
		}
		response.sendRedirect("buyshow.jsp");
	} else if (action.equals("remove")) {
		String id = request.getParameter("id");
		myCar.removelItem(id);
		db con=new db();
		try{
		String sql = "update book set BookNum=BookNum+1 where BookId=?";
		PreparedStatement pst = con.PreparedStatement(sql);
		pst.setString(1,id);
		pst.executeQuery();}
		catch(SQLException e) {
			System.out.println(e.toString());
		}
		response.sendRedirect("buyshopcar.jsp");
	} else if (action.equals("clear")) {
		myCar.clearCar();
		response.sendRedirect("buyshopcar.jsp");
	} else if (action.equals("save")) {
		db dbcon = new db();
		if (buylist == null || buylist.size() == 0) {
			try{
			String sql = "selsect * from shopcar where username=? and testno=0";
			PreparedStatement pst = dbcon.PreparedStatement(sql);
			pst.setString(1,username);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				String sq = "update shopcar set testno=1 where username=?";
				PreparedStatement ps = dbcon.PreparedStatement(sq);
				ps.setString(1,username);
				ResultSet r=ps.executeQuery();
			}}catch(SQLException e) {
				System.out.println(e.toString());
			}
		} else {
			for (int i = 0; i < buylist.size(); i++) {
				GoodsSingle single = (GoodsSingle) buylist.get(i);
				String no = single.getBookId();
				String name = single.getBookName();
				String publishName = single.getPublishName();
				String bookpic = single.getBookPic();
				int price = single.getBookPrice();
				int num = single.getBookNum();
				float money = ((int) ((price * num + 0.05f) * 10)) / 10f;
				total += money;
				try {
				String sql = "insert into shopcar values(?,?,?,?,?,?,?,?)";
				PreparedStatement prestate = dbcon.PreparedStatement(sql);
				prestate.setString(1, username);
				prestate.setString(2, no);
				prestate.setString(3, name);
				prestate.setInt(4,price);
				prestate.setInt(5,num);
				prestate.setString(6, publishName);
				prestate.setString(7, bookpic);
				prestate.setInt(8,0);
				prestate.executeQuery();}
				catch(SQLException e) {
					System.out.println(e.toString());
				}
			}
		}

		myCar.clearCar();
		response.sendRedirect("login.jsp");
	}else if (action.equals("pay")) {
		db dbcon=new db();
		for (int i = 0; i < buylist.size(); i++) {
			GoodsSingle single = (GoodsSingle) buylist.get(i);
			String no = single.getBookId();
			String name = single.getBookName();
			String publishName = single.getPublishName();
			String bookpic = single.getBookPic();
			int price = single.getBookPrice();
			int num = single.getBookNum();
			float money = ((int) ((price * num + 0.05f) * 10)) / 10f;
			total += money;
			try {
			String sql = "insert into pay values(?,?,?,?,?,?,?,?)";
			PreparedStatement prestate = dbcon.PreparedStatement(sql);
			prestate.setString(1, username);
			prestate.setString(2, no);
			prestate.setString(3, name);
			prestate.setInt(4,price);
			prestate.setInt(5,num);
			prestate.setString(6, publishName);
			prestate.setString(7, bookpic);
			prestate.setFloat(8, total);
			prestate.executeQuery();}
			catch(SQLException e) {
				System.out.println(e.toString());
			}
		}
		myCar.clearCar();
		response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("buyshow.jsp");
	}
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