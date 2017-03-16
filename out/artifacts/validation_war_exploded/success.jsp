<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: zhenz
  Date: 2017/3/1
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
<%
String n = (String) request.getAttribute("id");
String name = (String)request.getAttribute("name");
%>
亲爱的会员<%=name%>,恭喜你登录成功！
</body>
</html>
