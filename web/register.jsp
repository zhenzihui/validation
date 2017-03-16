<%--
  Created by IntelliJ IDEA.
  User: zhenz
  Date: 2017/3/1
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成为会员</title>
    <script>
        function comfirm() {
            var psw = document.getElementById("psw");
            var com = document.getElementById("con");
            var name = document.getElementById("name");

            if(psw.value!=com.value)
            {
                alert("两次密码输入不正确");
                return false;
            }
            if(name.value==null||name.value=="")
            {
                alert("用户名必须填");
                return false;
            }

            return true;
        }

        
    </script>
    
</head>
<body>
<div align="center">
    <form class="control-box" action="/register" method="post" onsubmit="return comfirm()">
        <div class="container">
        <label>用户名：</label><input type="text" name="name" id="name">
        </div>
        <div class="container">
            <label>密码：</label>
        <input type="password" name="password" id="psw">
        </div>
        <div class="container">
            <label>确认：</label>
        <input type="password" name="confirm" id="con">
        </div>
        <input type="submit" class="alert" value="注册" >

    </form>

</div>
</body>
</html>
