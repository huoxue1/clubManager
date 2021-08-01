package com.clubmg.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    private long uid;
    private long account;
    private String password;
    private String name;
    private int permit;
    private String sex;
    private String phone;
    private String grade;
    private String position;

    @Id
    @Column(name = "uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "account")
    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "permit")
    public int getPermit() {
        return permit;
    }

    public void setPermit(int permit) {
        this.permit = permit;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid && account == user.account && permit == user.permit && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(sex, user.sex) && Objects.equals(phone, user.phone) && Objects.equals(grade, user.grade) && Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, account, password, name, permit, sex, phone, grade, position);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", account=" + account +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", permit=" + permit +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", grade='" + grade + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
