<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="db" class="db.db" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新书入库</title>
<style type="text/css">
body {
	background-image: url(./images/08.jpg);
	background-repeat: repeat;
	background-size: 100% 100%;
}

td {
	text-align: center;
	text-align: justify;
	text-justify: distribute-all-lines;
	text-align-last: justify
}
</style>
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
</head>
<body>
	<h2 align=center>新书入库</h2>
	<form action="dealbookadd.jsp" method="post">
		<table align=center>
			<tr>
				<td>图书编号：
				<td><input name=BookId size=18>
			<tr>
				<td width=30%>图书名：
				<td><input name=BookName id=BookName size=18>
			<tr>
				<td>图片上传：
				<td><input type="file" id="book-file" onchange="show(this)"
					name="BookPic">
			<tr>
				<td>图片预览：
				<td><img id="BookPic" width="200" height="300" alt="暂无图片">
			<tr>
				<td>图书价格：
				<td><input name=BookPrice id=BookPrice size=18>
			<tr>
				<td width=30%>作者：
				<td><input name=Author id=Author size=18>
			<tr>
				<td>图书数量：
				<td><input name=BookNum id=BookNum size=18>
			<tr>
				<td>图书种类：
				<td><select id=BookType name=BookType>
						<option value="散文">散文</option>
						<option value="小说">小说</option>
						<option value="诗歌">诗歌</option>
						<option value="教辅">教辅</option>
				</select>
			<tr>
				<td>出版时间：
				<td><input name=PubTime id="datepicker" size=18>
			<tr>
				<td>出版社：
				<td><select id=PublishName name=PublishName>
						<option value="清华大学出版社">清华大学出版社</option>
						<option value="南京大学出版社">南京大学出版社</option>
						<option value="东南大学出版社">东南大学出版社</option>
				</select>
			<tr>
				<td>&nbsp;
			<tr>
				<td align=center colspan=2><input type="reset" value="重新填写">
					<input type="submit" value="提交记录">
		</table>
	</form>
</body>
</html>