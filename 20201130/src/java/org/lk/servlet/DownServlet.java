package org.lk.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "DownServlet",urlPatterns = {"*.action"})
public class DownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            downs(request,response);

    }

    protected void downs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //不能写这个输出对象
//        PrintWriter out = response.getWriter();
        //中文处理使用过滤器
        //请求数据
        String str = request.getParameter("fileName");
        System.out.println(str);

        //文件名  C:\Users\ASUS\Desktop\images\4.jpg
        String path = "C:\\Users\\ASUS\\Desktop\\images\\";
        //4.jpg
        path=path+str;
        System.out.println(path);

        //输入流
        FileInputStream fis = new FileInputStream(path);

//       响应头信息
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+str);

        //文件写入
        ServletOutputStream outs = response.getOutputStream();
        byte[] bt = new byte[1024];
        int length = 0;
        while((length=fis.read(bt))!=-1) {
            outs.write(bt, 0, length);
        }

        //关闭文件流
        outs.close();
        fis.close();


    }
}
