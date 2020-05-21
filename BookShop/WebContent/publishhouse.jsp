<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>出版社管理</title>
<link rel="stylesheet" type="text/css" href="css/page.css">
<style type="text/css">
body {
	background-image: url(./images/21.jpg);
	background-size: cover;
}
</style>
</head>
<body style="padding-top: 20px;">
	<div class="container">
		<div class="col-md-8 col-md-offset-2">
			<input type="text" class="form-control" name="keyword"> <a
				class="btn btn-info" href="./publishSearchSrevlet？keyword ">搜索</a><br>
			<table class="table">
				<thead>
					<td>名称</td>
					<td>地址</td>
					<td>联系方式</td>
					<td>登记时间</td>
					<td>贡献图书</td>
					<td>操作</td>
				</thead>
				<tbody>
					<c:forEach items="${publishlist}" var="ss">
						<tr>
							<td>${ss.publishName}</td>
							<td>${ss.publishPlace}</td>
							<td>${ss.publishNumber}</td>
							<td>${ss.insertDate}</td>
							<td>${ss.books}</td>
							<td><a class="btn btn-info btn-sm"
								href="./PublishUpdateServlet?publishName=${ss.publishName}">更
									新</a> <a class="btn btn-danger btn-sm"
								href="./PublishDelectServlet?publishName=${ss.publishName}">删
									除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn btn-success" href="publishadd.jsp">添加出版社</a>
		</div>
	</div>
</body>
</html>