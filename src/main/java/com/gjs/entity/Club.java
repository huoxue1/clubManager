package com.gjs.entity;

import java.io.Serializable;

/**
 * 社团(Club)实体类
 *
 * @author makejava
 * @since 2021-11-01 14:48:20
 */
public class Club implements Serializable {
    private static final long serialVersionUID = 133927825007149464L;
    /**
     * 社团id
     */
    private Integer clubId;
    /**
     * 社团头像
     */
    private String clubAvatar;
    /**
     * 社团名称
     */
    private String clubName;
    /**
     * 社团简介
     */
    private String introduction;
    /**
     * 社团口号
     */
    private String slogan;
    /**
     * 社长用户id
     */
    private Integer presidentId;
    /**
     * 社团成立时间
     */
    private Long createTime;
    /**
     * 一号管理员
     */
    private Integer admin1;
    /**
     * 二号管理员
     */
    private Integer admin2;
    /**
     * 三号管理员
     */
    private Integer admin3;
    /**
     * 审批审批状态
     */
    private Integer state;


    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubAvatar() {
        return clubAvatar;
    }

    public void setClubAvatar(String clubAvatar) {
        this.clubAvatar = clubAvatar;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Integer getPresidentId() {
        return presidentId;
    }

    public void setPresidentId(Integer presidentId) {
        this.presidentId = presidentId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getAdmin1() {
        return admin1;
    }

    public void setAdmin1(Integer admin1) {
        this.admin1 = admin1;
    }

    public Integer getAdmin2() {
        return admin2;
    }

    public void setAdmin2(Integer admin2) {
        this.admin2 = admin2;
    }

    public Integer getAdmin3() {
        return admin3;
    }

    public void setAdmin3(Integer admin3) {
        this.admin3 = admin3;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}

