package com.gjs.entity;

import java.io.Serializable;

/**
 * 活动记录(Activity)实体类
 *
 * @author makejava
 * @since 2021-11-01 15:32:56
 */
public class Activity implements Serializable {
    private static final long serialVersionUID = -74312909116158995L;

    private Integer id;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动主题
     */
    private String activityTheme;
    /**
     * 活动介绍
     */
    private String activityDescription;
    /**
     * 活动开始时间
     */
    private Long startTime;
    /**
     * 活动结束时间
     */
    private Long endTime;
    /**
     * 主办社团id
     */
    private Integer clubId;
    /**
     * 主办人id
     */
    private Integer userId;
    /**
     * 通过报名者请求方式，0手动审核，1自动通过所有
     */
    private Integer requestMethod;
    /**
     * 活动是否通过审核
     */
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityTheme() {
        return activityTheme;
    }

    public void setActivityTheme(String activityTheme) {
        this.activityTheme = activityTheme;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(Integer requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}

