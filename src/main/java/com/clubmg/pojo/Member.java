package com.clubmg.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Member implements Serializable {
    private long uid;
    private long cid;
    private int permit;
    private String position;
    private int state1;
    private Integer state2;

    @Id
    @Column(name = "uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Id
    @Column(name = "cid")
    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
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
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "state1")
    public int getState1() {
        return state1;
    }

    public void setState1(int state1) {
        this.state1 = state1;
    }

    @Basic
    @Column(name = "state2")
    public Integer getState2() {
        return state2;
    }

    public void setState2(Integer state2) {
        this.state2 = state2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (uid != member.uid) return false;
        if (cid != member.cid) return false;
        if (permit != member.permit) return false;
        if (state1 != member.state1) return false;
        if (position != null ? !position.equals(member.position) : member.position != null) return false;
        if (state2 != null ? !state2.equals(member.state2) : member.state2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + (int) (cid ^ (cid >>> 32));
        result = 31 * result + permit;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + state1;
        result = 31 * result + (state2 != null ? state2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Member{" +
                "uid=" + uid +
                ", cid=" + cid +
                ", permit=" + permit +
                ", position='" + position + '\'' +
                ", state1=" + state1 +
                ", state2=" + state2 +
                '}';
    }
}
