
    <%@page contentType="text/html;charset=utf-8" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="chat.WordSingle" %>
    <%@page import="java.sql.*"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type ="text/css">
body {
left:0px;
margin: 0px;
padding:0px;
background-image:url(./images/2019.jpg);
font–family:'lucida grande','lucida sans unicode','宋体','新宋体',arial,verdana,sans–serif;
color:#000;
font–size:0px;
}
}
</style>



</head>   <%
    ArrayList wordlist=(ArrayList)application.getAttribute("wordlist");
    if(wordlist==null||wordlist.size()==0)
    out.print("留言内容为空！");
    else{ 
   
    	for(int i=wordlist.size()-1;i>=0;i--){
    		WordSingle single=(WordSingle)wordlist.get(i);
			 %>
	   			留言者：<%=single.getUserName()%>
	   			<p>
	   			留言时间：<%=single.getTime() %>
	   			<p>
	   			会员编号：<%=single.getUserId()%>
	   			<p>
	   			留言内容：<%=single.getContent() %>
	   			<a href="ChatIndex.jsp">继续留言</a>
	   			<hr width="100%">
	   			<% 
			
   		
   
      }
         	}
    
    %>
    
  </html>