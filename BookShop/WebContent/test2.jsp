<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交成功</title>
</head>
<body>
<font color="red" size="5">账户名或密码错误，请重新登陆 <br> <br> </font>
<%response.setHeader("refresh", "1;URL=login.jsp"); %>
<br> 
</body>
</html>