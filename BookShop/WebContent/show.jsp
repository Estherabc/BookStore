<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息显示</title>
<style type="text/css">
body {
	background-image: url(./images/12.jpg);
	background-size: cover;
}
</style>
<script type="text/javascript">
function a()
{ 
	if(confirm('确认删除吗？')) {
		location.href='bookDelect.jsp?BookId=" + rs.getString("BookId") + "';
	}	return false;
	}
</script>
</head> 
<body>
	<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
	<form action="searchBook.jsp" method="post">
		搜索图书：<input type="text" name="search"> 
		       <input type="submit" value="查询">
	</form>
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
		<%
		String upd = null, del = null;
		upd = "<a href=bookupdate.jsp?BookId=" + rs.getString("BookId") + " >修改</a>";
		del = "<a onclick=a(); >删除</a>";
		
		%>
		<%
			for (int iPage = 1; iPage <= PageSize; iPage++){
			out.print("<tr>");
				out.print("<td>" + rs.getString("BookId") + "</td>");
				out.print("<td>" + rs.getString("BookName") + "</td>");
				out.print("<td><img width=80 height=100 src="+rs.getString("BookPic")+">");
				out.print("<td>" + rs.getString("BookPrice") + "</td>");
				out.print("<td>" + rs.getString("Author") + "</td>");
				out.print("<td>" + rs.getString("BookNum") + "</td>");
				out.print("<td>" + rs.getString("BookType") + "</td>");
				out.print("<td>" + rs.getString("PubTime") + "</td>");
				out.print("<td>" + rs.getString("PublishName") + "</td>");
				out.print("<td>" + upd + "</td>");
				out.print("<td>" + del + "</td>");
				out.print("</tr>");
				if(!rs.next())
					break;
			}
		%>
		<tr>
			<td colspan="11" align="center"><a href="bookAdd.jsp">新书入库</a></td>
	</table>
	<%	
		stmt.close();
		con.close();
	%>
	<FORM Action="show.jsp" Method="get">
		<%
			if (Page != 1) {
				out.print("<a href=show.jsp?Page=1>第一页</a>");
				out.print("<a href=show.jsp?Page=" + (Page - 1) + ">上一页</a>");
			}
			if (Page != totalPage) {
				out.print("<a href=show.jsp?Page=" + (Page + 1) + ">下一页</a>");
				out.print("<a href=show.jsp?Page=" + totalPage + ">最后一页</a>");
			}
		%>
		<BR>输入页数：<input TYPE="TEXT" Name="Page" SIZE="3"> 
		<input type="submit" value="go"> 页数:<font COLOR="Red"><%=Page%>/<%=totalPage%></font>
	</FORM>
</body>
</html>