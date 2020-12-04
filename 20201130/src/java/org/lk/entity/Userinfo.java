package org.lk.entity;

/**
 * @ClassName: Userinfo
 * @Description: TODO
 * @Author: 沈佳程
 * @date: 2020/11/28 9:42
 * @Version: V1.0
 */

public class Userinfo {
    private int id;
    private String username;
    private String password;

    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Userinfo() {
    }
//用来修改的构造方法
    public Userinfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    //用来查找的构造方法
    public Userinfo(String username) {
        this.username = username;
    }

    //用来登录,新增，的构造方法
    public Userinfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Userinfo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
