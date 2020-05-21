<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书店登陆</title>
<style type="text/css">
body {
	background-image: url("./images/login.jpg");;
	background-size: cover;
}
#login_frame {
	width: 400px;
	height: 260px;
	padding: 13px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -200px;
	background-color: rgba(240, 255, 255, 0.5);
	border-radius: 10px;
	text-align: center;
}
form p>* {
	display: inline-block;
	vertical-align: middle;
}
#image_logo {
	margin-top: 22px;
}
.label_input {
	font-size: 14px;
	font-family: 宋体;
	width: 65px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	color: white;
	background-color: #3CD8FF;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
}
.text_field {
	width: 278px;
	height: 28px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border: 0;
}
#btn_login {
	font-size: 14px;
	font-family: 宋体;
	width: 120px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	color: white;
	background-color: #3BD9FF;
	border-radius: 6px;
	border: 0;
	float: left;
}
#register {
	font-size: 16px;
	font-weight: bold;
	color: #903;
	text-decoration: none;
	position: relative;
	float: right;
	top: 5px;
}
#register:hover {
	color: blue;
	f text-decoration: underline;
}
#login_Ccontrol {
	padding: 0 28px;
}
#login_Ucontrol {
	padding:0   78px;
}
</style>
<script language="javascript">
function Validator(form1){
	  if(form1.username.value==""){
		  alert("请输入用户名");
		  form1.username.focus();
		  return(false);
	  }
	  else if(form1.password.value==""){
		  alert("请输入密码");
		  form1.password.focus();
		  return(false);
	  }
		  else return(true);
}
</script>
</head>
<body>
	<div id="login_frame">
		<p class="image_logo">
			<img src="./images/logo3.jpg" width=250 height=50>
		<form id="form1" method="post" action="" onsubmit="return Validator(this)">
			<p>
				<label class="label_input">用户名</label>
				<input type="text" name="username" class="text_field" />
			</p>
			<p>
				<label class="label_input">密码</label>
				<input type="password" name="password" class="text_field" />
			</p>
		<div id="login_Ccontrol">
		<input type="submit" id="btn_login" value="顾客登录" onclick="form1.action='buyloginmessage.jsp';form1.submit();"/>
		</div>	
		<div id="login_Ucontrol">	
		<input type="submit" id="btn_login" value="管理员登录" onclick="form1.action='ULoginServlet';form1.submit();" />
		</div>
			<a id="register" href="zhuce.jsp">没有账号，立即注册</a>
		</form>
	</div>
</body>
</html>