import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //获得参数值
        String name = request.getParameter("name");

        //模拟用户名多个
        List<String> list= Arrays.asList("林肯","lth","应天宇","john");

        int flag=0;

        //循环判断
        for (String str:list){
            //判断
            if(name.equals(str)){
                flag=1;
                break;

            }
        }
        System.out.println(flag);

        //响应结果
        out.print(flag);

        out.flush();
        out.close();
    }
}
