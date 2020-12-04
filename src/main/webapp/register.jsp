<%@ page import="org.lk.entity.Userinfo" %>
<%@ page import="UserinfoBiz" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/28
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1.中文处理
    request.setCharacterEncoding("utf-8");

    String userName = request.getParameter("userName");
    String passWord = request.getParameter("passWord");
    String email = request.getParameter("email");
    Userinfo of = new Userinfo(userName,passWord,email);
    UserinfoBiz us = new UserinfoBiz();
    int count = us.register(of);
    //判断
    if (count > 0) {
        response.sendRedirect("success.html");
    } else {
        response.sendRedirect("register.html");
    }


%>
