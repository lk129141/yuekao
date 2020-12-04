import biz.UserinfoBiz;
import biz.UserinfoBizImpl;
import entity.UserInfo;
import org.junit.Test;
import until.DateUtil;


import java.util.Date;
import java.util.List;

/**
 * @ClassName: TestUserinfo
 * @Description: TODO
 * @Author: lk
 * @date: 2020/12/3 15:55
 * @Version: V1.0
 */
public class TestUserinfo {
    @Test
    public void login() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        //封装对象
//        UserInfo user = new UserInfo("孙主管", "aaa");
        UserInfo user = new UserInfo("刘丽", "pass123");
        try {
            //调用方法
            UserInfo userInfo = biz.isLogin(user);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void all() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        //参数
        Object[] obj={"经"};
        try {
            //调用方法
//            List<UserInfo> userInfos = biz.all();
            List<UserInfo> userInfos = biz.all(obj);
            //循环遍历
            for(UserInfo userInfo:userInfos) {
                System.out.println(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void add() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        try {
            //util的日期
          Date dateUtil= DateUtil.stringToDate("yyyy-mm-dd","2020-10-10");

          //sql的日期
          java.sql.Date date= java.sql.Date.valueOf(DateUtil.dateToString("yyyy-mm-dd",dateUtil));

            //调用方法
            UserInfo user = new UserInfo("V0001","ll","123456",1,date,"123456498","商鼎","1");

            System.out.println(user);
            int count= biz.add(user);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void updates() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        try {
            //util的日期
            Date dateUtil= DateUtil.stringToDate("yyyy-mm-dd","2020-10-10");

            //sql的日期
            java.sql.Date date= java.sql.Date.valueOf(DateUtil.dateToString("yyyy-mm-dd",dateUtil));

            //调用方法
            UserInfo user = new UserInfo("AA",1,date,"123456498","商鼎","1","C0001");

            System.out.println(user);
            int count= biz.update(user);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
