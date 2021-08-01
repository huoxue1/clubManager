package com.clubmg.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Club {
    private long cid;
    private String cname;
    private Long admin1;
    private Long admin2;
    private Long admin3;
    private String introduction;
    private String scene;
    private int state;

    @Id
    @Column(name = "cid")
    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "admin1")
    public Long getAdmin1() {
        return admin1;
    }

    public void setAdmin1(Long admin1) {
        this.admin1 = admin1;
    }

    @Basic
    @Column(name = "admin2")
    public Long getAdmin2() {
        return admin2;
    }

    public void setAdmin2(Long admin2) {
        this.admin2 = admin2;
    }

    @Basic
    @Column(name = "admin3")
    public Long getAdmin3() {
        return admin3;
    }

    public void setAdmin3(Long admin3) {
        this.admin3 = admin3;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "scene")
    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return cid == club.cid && state == club.state && Objects.equals(cname, club.cname) && Objects.equals(admin1, club.admin1) && Objects.equals(admin2, club.admin2) && Objects.equals(admin3, club.admin3) && Objects.equals(introduction, club.introduction) && Objects.equals(scene, club.scene);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname, admin1, admin2, admin3, introduction, scene, state);
    }

    @Override
    public String toString() {
        return "Club{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", admin1=" + admin1 +
                ", admin2=" + admin2 +
                ", admin3=" + admin3 +
                ", introduction='" + introduction + '\'' +
                ", scene='" + scene + '\'' +
                ", state=" + state +
                '}';
    }
}
