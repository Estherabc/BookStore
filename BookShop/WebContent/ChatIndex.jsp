<%@ page language="java" contentType="text/html; charset=UTF-8"
    %>
    
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type ="text/css">
<!--
body{background-image:url(./images/cuicui2.jpg) }


.divForm{
position: absolute;/*绝对定位*/
width: 300px;
height: 200px;
background-image:url(./images/1920.jpg);
border: 1px solid red;
text-align: center;/*(让div中的内容居中)*/
top: 50%;
left: 50%;
margin-top: -200px;
margin-left: -150px;
}

-->
</style>
</head>
<body>
<div class="divForm"> 
<form action ="addWord" method="post">
会员昵称：<input type="text" name="userName" size="25">
<br>
会员编号：<input type="text" name="userId" size="25">
<br>
留言内容：<input type="text" name="content" size="25">
<p>
<input type="submit" value="提交">
<input type="reset" value="重置">
<a href="ChatShow.jsp">查看留言内容</a></form></div> 

</body>
</html>