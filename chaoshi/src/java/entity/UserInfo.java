package entity;

import java.sql.Date;

/**
 * @ClassName: Userinfo
 * @Description: TODO
 * @Author: lk
 * @date: 2020/11/30 14:23
 * @Version: V1.0
 */
public class UserInfo {
    private String userId;
    private String userName;
    private String passWord;
    private Integer sex;
    private Date bornDate;
    private String userTel;
    private String userAddress;
    private String typeID;
    //实体类对象
    private UserType userType;



    public UserInfo() {
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    //用来登录的构造方法
    public UserInfo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    //用来新增用户的构造方法
    public UserInfo(String userId, String userName, String passWord, Integer sex, Date bornDate, String userTel, String userAddress, String typeID) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.sex = sex;
        this.bornDate = bornDate;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.typeID = typeID;
    }
    //构造方法：新增前判断这个用户是否存在
    public UserInfo(String userName) {
        this.userName = userName;
    }



    //修改

    public UserInfo(String userName, Integer sex, Date bornDate, String userTel, String userAddress,String typeID,String userId) {
        this.userName = userName;
        this.sex = sex;
        this.bornDate = bornDate;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.typeID = typeID;
        this.userId = userId;
    }

    /*
     *封装
     * */

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", bornDate='" + bornDate + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", typeID=" + typeID +
                '}';
    }
}