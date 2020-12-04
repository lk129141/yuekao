<%@ page import="UserinfoBiz" %>
<%@ page import="org.lk.entity.Userinfo" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/28
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1.中文处理
    request.setCharacterEncoding("utf-8");

    //2.获取参数值
    String userName=request.getParameter("userName");
    String passWord=request.getParameter("passWord");

    Userinfo of = new Userinfo(userName, passWord);
    UserinfoBiz us = new UserinfoBiz();
    int count = us.add(of);

    System.out.println("count="+count);

    //判断
    if(count>0){
        response.sendRedirect("book.html");
    }else{
        response.sendRedirect("login.html");
    }

%>