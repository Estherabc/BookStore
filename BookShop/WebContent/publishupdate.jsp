<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>出版社管理</title>
<link rel="stylesheet" type="text/css" href="css/page.css">
<style type="text/css">
body {
	background-image: url(./images/yinghua.jpg);
	background-size: cover;
}
</style>
</head>
<body style="padding-top: 20px;">
	<div class="container">
		<div class="col-md-8 col-md-offset-2">
			<h1>更新出版社信息</h1>
			<br>
			<form action="./PublishUpdateServlet" method="post">
				<div class="form-group">
					<label>名称</label> <input type="test" class="form-control"
						name="publishName" value="${publish.publishName}">
				</div>
				<div class="form-group">
					<label>地址</label> <input type="text" class="form-control"
						name="publishPlace" value="${publish.publishPlace}">
				</div>
				<div class="form-group">
					<label>联系方式</label> <input type="text" class="form-control"
						name="publishNumber" value="${publish.publishNumber}">
				</div>
				<div class="form-group">
					<label>登记日期</label> <input type="date" class="form-control"
						name="insertDate" value="${publish.insertDate}">
				</div>
				<div class="form-group">
					<label>贡献图书</label> <input type="text" class="form-control"
						name="books" value="${publish.books}">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-info">确认更新</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>