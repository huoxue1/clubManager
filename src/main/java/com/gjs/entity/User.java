package com.gjs.entity;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @description user
 * @author zhengkai.blog.csdn.net
 * @date 2021-09-29
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Integer userId;

    /**
     * user_avatar
     */
    @Column(name="user_avatar")
    private String userAvatar;

    /**
     * 姓名
     */
    @Column(name="name")
    private String name;

    /**
     * 账号
     */
    @Column(name="account")
    private String account;

    /**
     * 密码
     */
    @Column(name="password")
    private String password;

    /**
     * 电话
     */
    @Column(name="phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name="email")
    private String email;

    /**
     * 性别
     */
    @Column(name="sex")
    private String sex;

    /**
     * 用户权限
     */
    @Column(name="permit")
    private Integer permit;

    /**
     * 班级id
     */
    @Column(name="grade")
    private Integer grade;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return account.hashCode();
    }
}