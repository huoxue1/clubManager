package com.gjs.entity;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * 社团成员记录(ClubMember)实体类
 *
 * @author makejava
 * @since 2021-11-01 15:24:02
 */
public class ClubMember implements Serializable {
    private static final long serialVersionUID = -96561258795504948L;
    
    private Integer id;
    /**
     * 成员id
     */
    private Integer userId;
    /**
     * 社团id
     */
    private Integer clubId;
    /**
     * 申请时间
     */
    private Long applyTime;
    /**
     * 通过时间
     */
    private Long passTime;
    /**
     * 是否审批通过
     */
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    public Long getPassTime() {
        return passTime;
    }

    public void setPassTime(Long passTime) {
        this.passTime = passTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}

