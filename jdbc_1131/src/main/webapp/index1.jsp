<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/1
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        body{
            /*background: coral;*/
        }

    </style>
</head>
<%--引入Jquery--%>
<script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
<%--外部JS--%>
<script type="text/javascript" src="js/indexEmail.js"></script>
<%--<script type="text/javascript" src="js/indexPost.js"></script>--%>
<%--<script type="text/javascript" src="js/indexAjax.js"></script>--%>
<%--<script type="text/javascript" src="js/indexGet.js"></script>--%>
<%--<script type="text/javascript" src="js/indexPosts.js"></script>--%>

<body>
<table>
    <tr>
        <td>邮箱<input type="text" name="email" id="email"/>&nbsp;<span id="no1" style="color:crimson">*</span></td>
    </tr><tr>
    <td>账号<input type="text" name="name" id="name"/>&nbsp;<span id="no2" style="color:crimson">*</span></td>
</tr>
    <tr>
        <td>密码<input type="password" name="password" id="password"/>&nbsp;<span id="no3" style="color:crimson">*</span></td>
    </tr>
    <tr>
        <td><input type="button" value="登录" name="but" id="buts" /></td>
    </tr>
    <tr>
        <td>
            <div id="nameDiv" style="display: inline"></div>
        </td>
    </tr>
</table>
</body>
</html>