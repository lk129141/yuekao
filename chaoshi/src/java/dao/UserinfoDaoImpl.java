package dao;

import entity.UserInfo;
import until.BaseDao;

import java.util.List;


/**
 * @ClassName: UserinfoDaoImpl
 * @Description: TODO
 * @Author: lk
 * @date: 2020/12/3 13:52
 * @Version: V1.0
 */
public class UserinfoDaoImpl extends BaseDao implements UserinfoDao {
    @Override
    public UserInfo isLogin(UserInfo userInfo) throws Exception {
        //sql语句
        String sql = "SELECT * from userinfo WHERE userName=? and `passWord`=?";
        //参数
        Object[] obj = {userInfo.getUserName(), userInfo.getPassWord()};
        //调用方法
        return this.excuteOneQuery(sql, UserInfo.class, obj);
    }

    @Override
    public int add(UserInfo userInfo) throws Exception {
        //sql语句
        String sql = "INSERT into userinfo VALUES(?,?,?,?,?,?,?,?)";
        Object[] obj = {userInfo.getUserId(),userInfo.getUserName(),userInfo.getPassWord(),userInfo.getSex(),userInfo.getBornDate(),userInfo.getUserTel(),userInfo.getUserAddress(),userInfo.getTypeID()};
        //调用方法
        return this.excuteUpdate(sql,obj);
    }

    @Override
    public int del(String id) {
        return 0;
    }

    @Override
    public int update(UserInfo userInfo) throws Exception {
        String sql = "update into userinfo VALUES(?,?,?,?,?,?) WHERE id=？";
        Object[] obj = {userInfo.getUserName(),userInfo.getSex(),userInfo.getBornDate(),userInfo.getUserTel(),userInfo.getUserAddress(),userInfo.getTypeID(),userInfo.getUserId()};
        //调用方法
        return this.excuteUpdate(sql,obj);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<UserInfo> all(Object... param) throws Exception {
        String sql = "";
        List<UserInfo> list = null;
        if (param.length == 0) {
            //sql语句
            sql = "SELECT * from userinfo";
            //调用方法
            list = this.excuteMoreQuery(sql, UserInfo.class);
        } else {
            sql = "SELECT * from userinfo where username like ?";
            //参数
            Object[] obj = {"%" + param[0] + "%"};
            //调用方法
            list = this.excuteMoreQuery(sql, UserInfo.class, obj);
        }
        return list;
    }
}
