<%@ page import="java.util.List" %>
<%@ page import="org.sjc.entity.Userinfo" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/30
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl包--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--默认值是true,是字符串；那么就必须修改成false,要转义；--%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        <!--
        .style1 {
            color: #000066;
            font-weight: bold;
        }
        .style2 {color: #FF0000}
        -->
    </style>
    <%--引入jQuery库--%>
    <script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/listUsers.js"></script>
</head>
<body bgcolor="#CCCCFF">
<table width="490" border="0" align="center">
    <tr>
        <td align="center"><img src="image/header.gif" width="468" height="60"></td>
    </tr>
    <tr>
        <td align="center"> 【<a href="all.do">用户管理</a>】【<a href="listNews.html">新闻管理</a>】【商铺管理】【论坛管理】【<a href="welcome.html">网站首页</a>】</td>
    </tr>
</table>
<br>
<table width="450" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="54" align="center"><span class="style1"><font size="7"><b><font face="华文彩云" size="6" color="#666699">用户列表显示：</font></b></font></span></td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="1" align="center" bordercolor="#660033" bgcolor="#99CCCC" cellspacing="1">
                <tr align="center">
                    <td width="25%">编号</td>
                    <td width="40%">用户名</td>
                    <td>用户密码</td>
                </tr>
                <%--循环
                   items:用于集合或数组 而且必须是保存过的(request,session,application.)
                   var : 变量名
                --%>
                <c:forEach items="${lists}" var="user">
                    <tr align="center">
                        <td width="25%"><a href="userInfo.jsp?id=${user.id}&uname=${user.username}&upwd=${user.password}">${user.id}</a></td>
                        <td width="40%">${user.username}</td>
                        <td>${user.password}</td>
                    </tr>
                </c:forEach>
            </table></td>
    </tr>
    <tr>
        <td align="right">
            第${pageInfo.currentPage}/${pageInfo.totalPage}页 &nbsp;

            <%--1-4--%>
             <c:forEach var="i" begin="1" end="${pageInfo.totalPage}" step="1">
                 <a href="all.do?pageIndex=${i}">${i}</a>
             </c:forEach>&nbsp;

            <%--下拉列表 change事件--%>
            <select id="slectPage">
              <c:forEach var="i" begin="1" end="${pageInfo.totalPage}" step="1">
                  <%--分支判断--%>
                  <c:choose>
                      <c:when test="${pageInfo.currentPage eq i}">
                          <option value="${i}" selected>${i}</option>
                      </c:when>
                      <c:otherwise>
                          <option value="${i}">${i}</option>
                      </c:otherwise>
                  </c:choose>
              </c:forEach>
            </select>页
            &nbsp;

            转到第<input type="text" name="no" id="no" style="width:25px; height: 20px">页  &nbsp;

            <a href="all.do?pageIndex=1">首页</a>||
            <a href="all.do?pageIndex=${pageInfo.currentPage-1<1?(1):(pageInfo.currentPage-1)}">上页</a>||
            <a href="all.do?pageIndex=${pageInfo.currentPage+1>pageInfo.totalPage?(pageInfo.totalPage):(pageInfo.currentPage+1)}">下页</a>||
            <a href="all.do?pageIndex=${pageInfo.totalPage}">末页</a>
        </td>
    </tr>
    <tr>
        <td align="center" height="40"><span class="style2">权利保留！！！</span></td>
    </tr>
</table>
</body>
</html>
