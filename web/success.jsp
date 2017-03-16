<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.sun.xml.internal.ws.client.sei.ResponseBuilder" %><%--
  Created by IntelliJ IDEA.
  User: zhenz
  Date: 2017/3/1
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>

    </script>
    <title>登陆成功</title>
</head>
<body>
<%
    String result;
    if((boolean)session.getAttribute("login")) {
        String n = (String) request.getAttribute("id");
        String name = (String) request.getAttribute("name");
       result ="亲爱的会员"+name+","+"会员号："+n+",恭喜你登录成功！";
    }
    else
        {
            result="请先登录";

        }
%>

<%=result%><button class="warning" value="注销" onclick=<%session.invalidate();%>></button>





</body>
</html>
