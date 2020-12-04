package org.lk;
import org.lk.entity.Userinfo;
import org.lk.until.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: Userserver
 * @Description: TODO
 * @Author: 林坤
 * @date: 2020/11/28 9:43
 * @Version: V1.0
 */

public class UserinfoBiz extends BaseDao {
    //新增
    public int add(Userinfo userinfo) {

        //sql语句
        String sql = "SELECT count(1) FROM userinfo where USERNAME=? AND `PASSWORD`=?";
        //设置值
        Object[] obj = new Object[]{userinfo.getUSERNAME(), userinfo.getPASSWORD()};

        ResultSet rs = null;
        //调用方法
        try {
            rs = this.queryQuery(sql, obj);

            //获得值
            rs.next();

            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            this.closeAll(rs, this.ps, this.con);
        }
        return 0;
    }


    //注册
    public int register(Userinfo userinfo) {
        //sql语句
        String sql = "INSERT into userinfo(USERNAME,`PASSWORD`,EMAIL) VALUES(?,?,?)";
        //设置值
        Object[] obj = new Object[]{userinfo.getUSERNAME(), userinfo.getPASSWORD(), userinfo.getEMAIL()};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
