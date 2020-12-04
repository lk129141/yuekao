package org.lk.servlet;



import org.lk.biz.UserinfoBiz;
import org.lk.entity.Userinfo;
import org.lk.until.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UserinfoServlet", urlPatterns = "*.do")
@MultipartConfig   //请求文件上传
public class UserinfoServlet extends HttpServlet {
    /**
     * 必须调用
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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


    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void reg0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //中文处理使用过滤器

        //请求数据
        String name = request.getParameter("textfield");
        String pwd = request.getParameter("textfield2");

        //封装数据
        Userinfo user = new Userinfo(name, pwd);

        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

        //调用业务方法
        int count = biz.register(user);

        //判断
        if (count > 0) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("addUser0.html");
        }

        //关闭
        out.flush();
        out.close();

    }


    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

         //1) 获得Part单个实例    <input type="file" name="img">
         Part part= request.getPart("img");

         //如果是多个 request.getParts()

         //2)获取文件头信息  Content-Disposition：form-data; name="img"; filename="1.jpg"
         String header=part.getHeader("Content-Disposition");
         System.out.println(header);

         //3)获取图片扩展名.jpg,.bmp,.gif....
        String suffix =header.substring(header.lastIndexOf("."),header.length()-1);
        System.out.println(suffix);

        //4)生成32位文件名
        String fileName= UUID.randomUUID()+suffix;
        System.out.println(fileName);

        //5)服务器路径
        String str = request.getServletContext().getRealPath("/upload");
        File file = new File(str);
        if(!file.exists()){
            file.mkdirs();
        }

        //6)完整的路径
        String path = str+"/"+fileName;
        System.out.println(path);

        //7)文件输入流
        InputStream is = part.getInputStream();
        //输出流 =>服务器路径
        OutputStream os = new FileOutputStream(path);
        byte[] bys=new byte[1024];
        int length=0;
        //读取数据
        while((length=is.read(bys))!=-1){
           //写入
            os.write(bys,0,length);
        }

        //关闭
        os.close();
        is.close();

        //中文处理使用过滤器

        //请求数据
        String name = request.getParameter("textfield");
        String pwd = request.getParameter("textfield2");

        //封装数据
        Userinfo user = new Userinfo(name, pwd);
        //存入图片数据
        user.setPicture(fileName);

        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

//        //调用业务方法
        int count = biz.register(user);

        //判断
        if (count > 0) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("addUser.html");
        }

        //关闭
        out.flush();
        out.close();

    }
    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //中文处理使用过滤器

        //请求数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPass");

        //封装数据
        Userinfo user = new Userinfo(name, pwd);

        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

        //调用业务方法
        int count = biz.login(user);

        //判断
        if (count > 0) {
            response.sendRedirect("welcome.html");
        } else {
            response.sendRedirect("index.html");
        }

        //关闭
        out.flush();
        out.close();

    }

    /**
     * 显示所有数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void all0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //中文处理使用过滤器

        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

        //调用业务方法
        List<Userinfo> list = biz.all();

        //保存数据(request ,使用转发)
        request.setAttribute("lists", list);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);

        //关闭
        out.flush();
        out.close();

    }


    /**
     * 实现分页
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

        //中文处理使用过滤器

        ////////////////////////////////////////////////////
        String str =request.getParameter("pageIndex");

        //当前页
        int pageIndex=(str==null)?(1):(Integer.parseInt(str));

        //每页显示个数
        int pageSize=5;

        //总个数
        int count =biz.all().size();

        //实例化分页对象
        PageInfo pageInfo =new PageInfo(count,pageSize,pageIndex);

        ////////////////////////////////////////////////

        //调用业务方法
        List<Userinfo> list = biz.getPageInfo(pageInfo);

        //保存数据(request ,使用转发)
        request.setAttribute("lists", list);
        request.setAttribute("pageInfo", pageInfo);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);

        //关闭
        out.flush();
        out.close();

    }

    /**
     * 更新
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //中文处理使用过滤器

        //请求数据
        String strId = request.getParameter("userID");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("password");

        //注意是2个提交按钮，获取参数值
        String sub = request.getParameter("Submit");


        //变量
        int count = 0;
        UserinfoBiz biz = null;

        //判断
        if ("修改".equals(sub)) {
            //封装数据
            Userinfo user = new Userinfo(Integer.parseInt(strId), name, pwd);
            //业务对象
            biz = new UserinfoBiz();
            //调用业务方法
            count = biz.update(user);
        } else {  //删除
            //业务对象
            biz = new UserinfoBiz();
            //调用业务方法
            count = biz.del(Integer.parseInt(strId));
        }

        //判断
        if (count > 0) {
            response.sendRedirect("all.do");
        } else {
            response.sendRedirect("userInfo.jsp");
        }

        //关闭
        out.flush();
        out.close();

    }



}
