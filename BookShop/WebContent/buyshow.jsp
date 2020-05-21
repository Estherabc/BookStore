<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="gcweb.GoodsSingle"%>
<%@page import="java.sql.*"%>
<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
<% ArrayList goodslist=(ArrayList)session.getAttribute("goodslist"); %>
<style type="text/css">
body {
	background-image: url(./images/13.jpg);
	background-size: cover;
}
</style>
	<%
		int PageSize = 3;
		int Page = 1;
		int totalPage = 1;
		int totalrecord = 0;
		Connection con = db.getConnection();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String selsql = "select * from book";
		ResultSet rs = stmt.executeQuery(selsql);
		if (rs.next()) {
			rs.last();
			totalrecord = rs.getRow();//得到记录集的总记录数（总行数）；   
			rs.first();
		}
		if (totalrecord % PageSize == 0)// 如果是当前页码的整数倍
			totalPage = totalrecord / PageSize;
		else // 如果最后还空余一页
			totalPage = (int) Math.floor(totalrecord / PageSize) + 1;
		if (totalPage == 0)
			totalPage = 1;
		if (request.getParameter("Page") == null || request.getParameter("Page").equals(""))
			Page = 1;
		else
			try {
				Page = Integer.parseInt(request.getParameter("Page"));
			} catch (java.lang.NumberFormatException e) {
				// 捕获用户从浏览器地址拦直接输入Page=sdfsdfsdf所造成的异常
				Page = 1;
			}
		if (Page < 1)
			Page = 1;
		if (Page > totalPage)
			Page = totalPage;
		rs.absolute((Page - 1) * PageSize + 1);
	%>
<table border="1" width="900" rules="none" cellspacing="0" cellpadding="0">
  <tr height="50">
    <td colspan="8" align="center">提供的商品如下</td>
  </tr>
  <tr align="center" height="100" bgcolor="lightgrey">
    <td>编号</td>
    <td>书名</td>
    <td>价格</td>
    <td>购买数量</td>
    <td>库存数量</td>
    <td>出版社</td>
    <td>图书图片</td>
    <td>购买</td>
  </tr>
 
 <%int i=-1; 
 if(goodslist==null||goodslist.size()==0){ %>
 <tr height="100">
   <td colspan="9" align="center">没有商品可显示！</td></tr>
 <%
 }
    else{
			for (int iPage = 1; iPage <= PageSize; iPage++){
		    		%>
		    		  <tr height="100" align="center">
		    		    <td><%=rs.getString("BookId")%></td>
		    		    <td><%=rs.getString("BookName")%></td>
		    		    <td><%=rs.getString("BookPrice")%></td>
		    		    <td><%=1%></td>
		    		    <td><%=rs.getInt("BookNum")%></td>
		    		    <td><%=rs.getString("PublishName")%></td>
		    		    <td><img alt="图片无法显示" border="0" src=<%=rs.getString("BookPic")%> width="90" height="91"></td>
		    		    <td><a href="buydocar.jsp?action=buy&id=<%=rs.getString("BookId")%>">购买</a></td>
		    		    </tr>
		    		    <%
		    		    if(!rs.next())
							break;
			}}
		    		 %>
		<%	
		stmt.close();
		con.close();
	%>
	<FORM Action="show.jsp" Method="get">
		<%
			if (Page != 1) {
				out.print("<a href=buyshow.jsp?Page=1>第一页</a>");
				out.print("<a href=buyshow.jsp?Page=" + (Page - 1) + ">上一页</a>");
			}
			if (Page != totalPage) {
				out.print("<a href=buyshow.jsp?Page=" + (Page + 1) + ">下一页</a>");
				out.print("<a href=buyshow.jsp?Page=" + totalPage + ">最后一页</a>");
			}
		%>
		<BR>输入页数：<input TYPE="TEXT" Name="Page" SIZE="3"> 
		<input type="submit" value="go"> 页数:<font COLOR="Red"><%=Page%>/<%=totalPage%></font>
	</FORM>
 <tr height="50">
   <td align="center" colspan="7"><a href="buyshopcar.jsp">查看购物车</a></td>
   </tr>
</table>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>