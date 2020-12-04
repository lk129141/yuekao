package org.lk.entity;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: 林坤
 * @date: 2020/11/28 9:42
 * @Version: V1.0
 */

public class Userinfo {
    private String USERNAME;
    private String PASSWORD;
    private String EMAIL;

    public Userinfo() {
    }


    public Userinfo(String USERNAME, String PASSWORD, String EMAIL) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.EMAIL = EMAIL;
    }

    public Userinfo(String USERNAME, String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
