<%@ page import="zhenz.Validator" %><%--
  Created by IntelliJ IDEA.
  User: zhenz
  Date: 2017/2/28
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>

    <title>会员登录</title>
  </head>
  <body>
    <div class="container">
      <form class="filler" method="post" action="/validate">
        <div align="center" class="container">
          <label>用户名：</label>
          <input class="text-input" name="name" type="text">
        </div>
        <div align="center" class="container">
          <label>密码：</label>
          <input class="text-input" name="password" type="password">
            <br><input type="submit" value="登录"> <a href="register.jsp">注册</a>
        </div>



      </form>

    </div>

  </body>
</html>
