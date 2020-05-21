<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<title>出版社管理</title>
<link rel="stylesheet" type="text/css" href="css/page.css">

<style type="text/css">
body {
	background-image: url(./images/38.jpg);
	background-size: cover;
}
</style>
</head>
<body style="padding-top: 20px;">
	<div class="container">
		<div class="col-md-8 col-md-offset-2"></div>
		<input type="text" class="form-control" name="keyword">
		<button class="btn btn-info"
			onclik="window.location.href='/WordSearchSrevlet'">搜索</button>
		<br>
		<table class="table">
			<thead>
				<td>会员编号</td>
				<td>会员昵称</td>
				<td>留言时间</td>
				<td>留言内容</td>
				<td>操作</td>
			</thead>
			<tbody>
				<c:forEach items="${wordlist}" var="word">
					<tr>
						<td>${word.userId}</td>
						<td>${word.userName}</td>
						<td>${word.time}</td>
						<td>${word.content}</td>
						<td><a class="btn btn-danger btn-sm"
							href="./WordDelectServlet?=${word.userId}">删 除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<div>
				<a class="btn btn-info btn-sm" href="choice.jsp">返回</a>
			</div>
			</body>
			
			