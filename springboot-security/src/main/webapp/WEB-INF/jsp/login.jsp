<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/12/21
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<form method="post" action="/login">
    用户名：<input  type="text" name="logName"/>
    密码：<input type="password" name="passWord"/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
