<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/1/8
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
单个文件上传<br>
<form action="/upload/up" method="post"  enctype="multipart/form-data">
<input type="file" name="file" />
    <input type="submit" value="文件上传"/>
</form>
</body>
</html>
