<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="gcweb.GoodsSingle"%>
<!-- 通过动作标识，获取shopcar类实例 -->
<jsp:useBean id="myCar" class="gcweb.ShopCar" scope="session"/>
<style type="text/css">
body {
	background-image: url(./images/cuicui1.jpg);
	background-size: cover;
}
</style>
<%
ArrayList buylist=myCar.getBuylist();
float total=0;
%>
<table border="1" width="900" rules="none" cellspacing="0" cellpadding="0">
  <tr height="50"><td colspan="5" align="center">预订书单如下</td></tr>
  <tr align="center" height="30" bgcolor="lightgrey">
     <td width="25%">编号</td>
    <td>书名</td>
    <td>价格</td>
    <td>预订数量</td>
    <td>出版社</td>
    <td>图书图片</td>
     <td>总价（元）</td>
     <td>移除(-1/次)</td>
   </tr>
   <%
     if(buylist==null||buylist.size()==0){%>
     <tr height="100"><td colspan="5" align="center">您的订单为空！</td></tr>
   <%
     }
     else{
    	 for(int i=0;i<buylist.size();i++){
    		 GoodsSingle single=(GoodsSingle)buylist.get(i);
    		 String no=single.getBookId();
    		 String name=single.getBookName();
    		 int price=single.getBookPrice();
    		 int num=single.getBookNum();
    		 String publish=single.getPublishName();
    		 String bookpic=single.getBookPic();
    		 float money=((int)((price*num+0.05f)*10))/10f;
    		 total+=money;
    %>
    <tr align="center" height="50">
    <td><%=no%></td>
    <td><%=name%></td>
    <td><%=price%></td>
    <td><%=num%></td>
    <td><%=publish%></td>
	<td><img alt="图片无法显示" border="0" src=<%=single.getBookPic()%> width="90" height="91"></td>
    <td><%=money%></td>
    <td>
       <a href="Bookdocar.jsp?action=remove&id=<%=single.getBookId()%>">移除</a>
    </td>
    </tr>
    <%
    	 }
     }
   %>
   <tr height="50"align="center"><td colspan="5">应付金额：<%=total%></td></tr>
   <tr height="50"align="center">
     <td colspan="2"><a href="Bookindex.jsp">继续预订</a></td>
     <td colspan="3"><a href="Bookdocar.jsp?action=clear">清空书单</a></td>
     <td colspan="3"><a href="Bookdocar.jsp?action=pay">预付定金</a></td>
     <td colspan="3"><a href="Bookdocar.jsp?action=save">退出</a></td>
   </tr>
</table>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>