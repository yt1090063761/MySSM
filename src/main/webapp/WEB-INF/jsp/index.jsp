<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/15
  Time: 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>用户管理</title>
</head>
<script TYPE="text/javascript" src="/webjars/jquery/3.4.0/jquery.js"></script>
<body>
<script>

   $(function () {

       $("#input").click(function () {
         alert("sa");


       });

   });
   <!--跳转到修改页面，并传id去查询 -->
   function updateUser(id) {
      //alert(id);

       window.open("updateUser.action?uid="+id,"修改用户","innerWidth=800px,innerHeight=600px");

   }

    function findbyname() {
       // alert($("#name").val());
          var Str={"name":$("#name").val()}
        //  alert(Str.name);
        $.ajax({
            type:"post",
            url:"findbyname.action?name="+$("#name").val(),
            Datatype:"json",
            Data:Str,
            success:function (data) {
                alert(data)
                var da=eval(data);
                alert(da)
               // alert("8s");
            },
            error:function () {
                alert("搜索异常。。。。。。。");
            }

        });

    }


</script>


用户名<input type="text" id="name"><button id="find" onclick="findbyname()">搜索</button>
<table>
    <tr>
        <td>用户名</td>
        <td>地址</td>
        <td>联系电话</td>
        <td>名字</td>
    </tr><br>
    <c:forEach items="${all1}" var="user">

        <tr>
            <td>${user.username}</td>
            <td>${user.addr}</td>
            <td>${user.phone}</td>
            <td>${user.name}</td>
            <td>
                <a href="delete.action?id=${user.uid}">删除</a>
                <a onclick="updateUser(${user.uid})" href="">修改</a>
                <%--<input type="hidden" value="${user.uid}">--%>
            </td>
                <%--<a href="put/postUser.action?id=${user.uid}">修改1</a></td>--%>

            <br>
        </tr>

    </c:forEach>



</table>


<a href="addUser.action">添加</a>
<%--<input id="input" type="button" value="tet">--%>

<input  type="button" onclick="bu();" value="测试点击事件">

<form action="/allorder" method="post">
    <input type="submit" value="显示所有订单">
</form>
</body>
</html>
