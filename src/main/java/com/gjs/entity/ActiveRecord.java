package com.gjs.entity;

import java.io.Serializable;

/**
 * 活动包名记录(ActiveRecord)实体类
 *
 * @author makejava
 * @since 2021-11-01 15:40:23
 */
public class ActiveRecord implements Serializable {
    private static final long serialVersionUID = 948541936404693125L;
    /**
     * 记录id
     */
    private Integer id;
    /**
     * 报名者id
     */
    private Integer userId;
    /**
     * 活动id
     */
    private Integer activityId;
    /**
     * 报名时间
     */
    private Long registerTime;
    /**
     * 是否通过审核
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}

