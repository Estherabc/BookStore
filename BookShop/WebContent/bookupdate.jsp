<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书记录</title>
<style type="text/css">
body {
	background-image: url(./images/09.jpg);
	background-size: cover;
}
</style>
<script type="text/javascript">
	function show(f) {
		var rd = new FileReader();//创建文件读取对象
		var files = f.files[0];//获取file组件中的文件
		rd.readAsDataURL(files);//文件读取装换为base64类型
		rd.onloadend = function(e) {
			//加载完毕之后获取结果赋值给img
			document.getElementById("BookPic").src = this.result;
		}
	}
</script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
	<%
		request.setCharacterEncoding("UTF-8");
		String sql = "select *from book where BookId='" + request.getParameter("BookId") + "'";
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		session.setAttribute("bookid", request.getParameter("BookId"));
	%>
	<form action="dealbookupd.jsp" method="post">
		<table>
			<tr>
				<td align="center" colspan="2">要修改的图书编号为：<%=request.getParameter("BookId")%></td>
			</tr>
			<tr>
				<td align="center">原信息</td>
				<td align="center">修改信息</td>
			</tr>
			<tr>
				<td>图书名：<%=rs.getString("BookName")%></td>
				<td><input type="text" value=<%=rs.getString("BookName")%>
					name="BookName"></td>
			</tr>
			<tr>
				<td>图书图片：<%=rs.getString("BookPic")%></td>
				<td><input type="file" value=<%=rs.getString("BookPic")%> name="BookPic" id="book-file" onchange="show(this)"></td>
			
			</tr>
			<tr>
			<td><img width=180 height=260 src="<%=rs.getString("BookPic")%>">
			<td><img id="BookPic" width="180" height="260" alt="暂无图片">
			</tr>
			<tr>
				<td>图书价格：<%=rs.getString("BookPrice")%></td>
				<td><input type="text" value=<%=rs.getString("BookPrice")%>
					name="BookPrice"></td>
			</tr>
			<tr>
				<td>图书名：<%=rs.getString("Author")%></td>
				<td><input type="text" value=<%=rs.getString("Author")%>
					name="Author"></td>
			</tr>
			<tr>
				<td>图书数量：<%=rs.getString("BookNum")%></td>
				<td><input type="text" value=<%=rs.getString("BookNum")%>
					name="BookNum"></td>
			</tr>
			<tr>
				<td>图书种类：<%=rs.getString("BookType")%></td>
				
					<td><select id=BookType name=BookType>
						<option value="散文">散文</option>
						<option value="小说">小说</option>
						<option value="诗歌">诗歌</option>
						<option value="教辅">教辅</option>
				</select>
			</tr>
			<tr>
                 <td>出版时间：<%=rs.getString("PubTime")%></td>
				<td><input name=PubTime id="datepicker" size=18>
			</tr>
			<tr>
				<td>出版社名：<%=rs.getString("PublishName")%></td>
				<td><select id=PublishName name=PublishName>
						<option value="清华大学出版社">清华大学出版社</option>
						<option value="南京大学出版社">南京大学出版社</option>
						<option value="东南大学出版社">东南大学出版社</option>
				</select>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="提交"
					name="B1"> <input type="reset" value="重新填写" name="B2"></td>
			</tr>
		</table>
	</form>
</body>
</html>