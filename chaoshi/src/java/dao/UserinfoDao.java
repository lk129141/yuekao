package dao;

import entity.UserInfo;

import java.util.List;


public interface UserinfoDao {  //登录
    //登录
    UserInfo isLogin(UserInfo userInfo) throws Exception;

    //添加
    int add(UserInfo userInfo)throws Exception;

    //删除
    int del(String id) throws Exception;

    //修改
    int update(UserInfo userInfo) throws Exception;

    //根据ID查询
    UserInfo findById(String id)throws Exception;

    //查询所有(2)
    List<UserInfo> all(Object... param) throws Exception;


}