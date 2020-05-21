<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>出版社管理</title>
		<link rel="stylesheet" type="text/css" href="css/page.css">
	
<style type="text/css">
body {
	background-image: url(./images/30.jpg);
	background-size: cover;
}
</style>
</head>
	<body style="padding-top: 20px;">
		<div class="container">
			<div class="col-md-8 col-md-offset-2">
				<h1>添加出版社</h1><br>
				<form action="./PublishAddServlet" method="post">
					<div class="form-group">
						<label>名称</label>
						<input type="text" class="form-control" name="publishName">
					</div>
					<div class="form-group">
						<label>地址</label>
						<input type="text" class="form-control" name="publishPlace">
					</div>
					<div class="form-group">
						<label>联系方式</label>
						<input type="text" class="form-control" name="publishNumber">
					</div>
					<div class="form-group">
						<label>登记日期</label>
						<input type="date" class="form-control" name="insertDate">
					</div>
					<div class="form-group">
						<label>贡献图书</label>
						<input type="text" class="form-control" name="books">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-info">添加出版社</button>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>