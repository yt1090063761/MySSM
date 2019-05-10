<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

<form action="postUser.action" method="post">
    用户名：<input type="text" name="username" id="username">
    姓名：<input type="text" name="name">
    密码：<input type="password" name="password">
    联系电话<input type="text" name="phone">
    地址<input  name="addr"><br>
    <input type="submit" value="确认">
</form>
</body>
</html>
