<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>修改用户</title>
</head>
<script TYPE="text/javascript" src="/webjars/jquery/3.4.0/jquery.js"></script>

<body>
<script>

    $(function () {

        $("#submit").click(function () {
           // alert("as");
            var state=false;
            $.ajax({
                type: "POST",
                url: "updateUser1.action?uid=" + $("#uid").val()+"&name="+$("#name").val(),
                Datatype: "String",
               // Data: Str,
                success: function (data) {
                    alert(data)
                   // var da = eval(data);
                  //  alert(da)
                    state=true;
                       window.close();

                },
                error: function () {
                    alert("修改异常。。。。。。。");
                }

            });


        });


    });

</script>
<form action="updateUser.action" method="post">
    用户名：<input type="text" name="username" id="username">
    姓名：<input type="text" name="name" id="name" value="${user1.name}">
    密码：<input type="password" name="password">
    联系电话<input type="text" name="phone">
    地址<input name="addr">
    <input type="hidden" id="uid" value="${user1.uid}">
    <br>
    <input id="submit" type="button" value="修改">
</form>
</body>
</html>
