package org.lk.biz;

import org.lk.entity.Userinfo;
import org.lk.until.BaseDao;
import org.lk.until.PageInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserinfoBiz
 * @Description: TODO
 * @Author: 沈佳程
 * @date: 2020/11/28 9:43
 * @Version: V1.0
 */

public class UserinfoBiz extends BaseDao {
    /**
     * 登录
     *
     * @param userinfo
     * @return
     */
    //登录
    public int login(Userinfo userinfo) {

        //sql语句
        String sql = "SELECT COUNT(1) from userinfo WHERE username=? and `password`=?";
        //设置值
        Object[] obj = new Object[]{userinfo.getUsername(),userinfo.getPassword()};

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

    //新增前判断这个用户名是否存在，因为用户名是主键，在数据中不能重复增加
    public int judgeUsername(Userinfo userinfo) {

        //sql语句
        String sql = "SELECT count(1) FROM userinfo where username=?";
        //设置值
        Object[] obj = new Object[]{userinfo.getUsername()};

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
    public int register0(Userinfo userinfo) {
        //sql语句
        String sql = "INSERT into userinfo(username,`password`) VALUES(?,?)";
        //设置值
        Object[] obj = new Object[]{userinfo.getUsername(),userinfo.getPassword()};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    //注册
    public int register(Userinfo userinfo) {
        //sql语句
        String sql = "INSERT into userinfo(username,`password`,picture) VALUES(?,?,?)";
        //设置值
        Object[] obj = new Object[]{userinfo.getUsername(),userinfo.getPassword(),userinfo.getPicture()};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }



    //修改
    public int update(Userinfo userinfo) {
        //sql语句
        String sql = "UPDATE userinfo set username=?,`password`=? WHERE id=?";
        //设置值
        Object[] obj = new Object[]{userinfo.getUsername(),userinfo.getPassword(),userinfo.getId()};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    //删除
    public int del(int id) {
        //sql语句
        String sql = "delete from  userinfo  WHERE id=?";
        //设置值
        Object[] obj = new Object[]{id};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    //查询所有数据
    public List<Userinfo> all() {

        //存储数据
        List<Userinfo> list = new ArrayList<>();

        //sql语句
        String sql = "select * from  userinfo";
        ResultSet rs=null;
        //调用方法
        try {
             rs= this.queryQuery(sql);
            while(rs.next()){
                Userinfo userinfo =new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3));
                //保存到集合中
                list.add(userinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭
            this.closeAll(rs,this.ps,this.con);
        }

        return list;
    }


    //分页
    public List<Userinfo> getPageInfo(PageInfo pageInfo) {

        //存储数据
        List<Userinfo> list = new ArrayList<>();

        //sql语句
        //?:(当前页-1）*每页的个数
        //?:每页的个数
        String sql = "select * from userinfo LIMIT ?,?";

        //参数值
        Object[] objs={(pageInfo.getCurrentPage()-1)*pageInfo.getRows(),pageInfo.getRows()};

        ResultSet rs=null;
        //调用方法
        try {
            rs= this.queryQuery(sql,objs);
            while(rs.next()){
                Userinfo userinfo =new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3));
                //保存到集合中
                list.add(userinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭
            this.closeAll(rs,this.ps,this.con);
        }

        return list;
    }
}
