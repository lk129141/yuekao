package serlvet;


import biz.UserinfoBiz;
import biz.UserinfoBizImpl;
import entity.UserInfo;
import until.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: UserinfoServlet
 * @Description: TODO
 * @Author: lk
 * @date: 2020/12/3 18:30
 * @Version: V1.0
 */

@WebServlet(name = "UserinfoServlet",urlPatterns ="*.do" )
public class UserinfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求路径   /add.do
        String path = request.getServletPath();

        //截取 add
        String pathName = path.substring(1, path.lastIndexOf("."));

        //利用反射机制
        try {
            //pathName方法名; 后面2个是参数
            Method method = getClass().getDeclaredMethod(pathName, HttpServletRequest.class, HttpServletResponse.class);
            //调用
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭
        out.flush();
        out.close();
    }


    //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //请求数据
        //2.获取参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //3.封装
        UserInfo user = new UserInfo(username, password);
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();

        try {
            //调用方法,返回的是个对象
            UserInfo userInfo = biz.isLogin(user);
            if (userInfo.getUserName()!=null) {
                System.out.println(userInfo);
                //会话对象
                HttpSession session = request.getSession();
                session.setAttribute("name",userInfo.getUserName());
                //响应结果
                response.sendRedirect("welcome.jsp");
            } else {
                //响应结果
                response.sendRedirect("login.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭
        out.flush();
        out.close();
    }
    //添加
    protected void adds(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //.获取参数值
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String userpassword = request.getParameter("userpassword");
        String sex = request.getParameter("sex");
        String houseDate = request.getParameter("houseDate");
        String userphone = request.getParameter("userphone");
        String userAddress = request.getParameter("userAddress");
        String userlei = request.getParameter("userlei");
        Date date=null;
        int sex1=Integer.parseInt(sex);

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = ft.parse(houseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date hiredate=new java.sql.Date(date.getTime());
        UserInfo user = new UserInfo(userId, userName,userpassword,sex1,hiredate,userphone,userAddress,userlei);
        System.out.println(user);
        UserinfoBiz biz = new UserinfoBizImpl();
        int count= biz.add(user);
        if (count>0){
            response.sendRedirect("userList.html");
        }else{
            response.sendRedirect("userAdd.jsp");
        }
        //关闭
        out.flush();
        out.close();
    }
}