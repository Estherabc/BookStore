<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	background-image: url(./images/06.jpg);
	background-size: cover;
}
</style>
<body>
<div style ="text-align:CENTER">
    <FORM ACTION="formdeal.jsp" METHOD="POST">
		用户名：<INPUT TYPE="TEXT" NAME="username"><BR>
		密   码：<INPUT TYPE="PASSWORD" NAME="userpwd"><BR>
		性别：<INPUT TYPE="RADIO" NAME="sex" CHECKED>男
			 <INPUT TYPE="RADIO" NAME="sex">女 <BR>
		血型：<INPUT TYPE="RADIO" NAME="blood" CHECKED>O
			 <INPUT TYPE="RADIO" NAME="blood">A
			 <INPUT TYPE="RADIO" NAME="blood">B
			 <INPUT TYPE="RADIO" NAME="blood">AB <BR>
		爱好：<INPUT TYPE="checkbox" NAME="hobby" CHECKED>唱
			 <INPUT TYPE="checkbox" NAME="hobby">跳
			 <INPUT TYPE="checkbox" NAME="hobby">rap
			 <INPUT TYPE="checkbox" NAME="hobby">篮球 <BR>
		所在地：<INPUT TYPE="TEXT" NAME="place"><BR>
		文件：<INPUT TYPE="FILE"><BR>
		简介：<TEXTAREA ROWS="8" COLS="30"></TEXTAREA><BR>
		<INPUT TYPE="SUBMIT" VALUE="提交">
		<INPUT TYPE="RESET" VALUE="重置">
	</div>
	</FORM>
</body>
</html>