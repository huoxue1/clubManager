package com.gjs.entity;

import lombok.ToString;

import java.io.Serializable;

/**
 * 用户信息(User)实体类
 *
 * @author makejava
 * @since 2021-11-01 14:49:34
 */
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -84776490924839192L;

    private Integer userId;

    private String userAvatar;
    /**
     * 姓名
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private String sex;
    /**
     * 用户权限
     */
    private Integer permit;


    /**
     * 班级id
     */
    private Integer grade;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPermit() {
        return permit;
    }

    public void setPermit(Integer permit) {
        this.permit = permit;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

}

