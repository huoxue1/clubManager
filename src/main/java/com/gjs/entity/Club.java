package com.gjs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description club
 * @author gjs
 * @date 2021-10-07
 */
@Data
@ApiModel("club")
public class Club extends Grade implements Serializable {




    private static final long serialVersionUID = 1L;

    /**
     * 社团id
     */
    @ApiModelProperty("社团id")
    private Integer clubId;

    /**
     * 社团头像
     */
    @ApiModelProperty("社团头像")
    private String clubAvatar;

    /**
     * 社团名称
     */
    @ApiModelProperty("社团名称")
    private String clubName;

    /**
     * 社团简介
     */
    @ApiModelProperty("社团简介")
    private String introduction;

    /**
     * 社团口号
     */
    @ApiModelProperty("社团口号")
    private String slogan;

    /**
     * 社长用户id
     */
    @ApiModelProperty("社长用户id")
    private Integer presidentId;

    /**
     * 社团成立时间
     */
    @ApiModelProperty("社团成立时间")
    private String createTime;

    /**
     * 一号管理员
     */
    @ApiModelProperty("一号管理员")
    private Integer admin1;

    /**
     * 二号管理员
     */
    @ApiModelProperty("二号管理员")
    private Integer admin2;

    /**
     * 三号管理员
     */
    @ApiModelProperty("三号管理员")
    private Integer admin3;

    /**
     * 审批审批状态
     */
    @ApiModelProperty("审批审批状态")
    private Integer state;

    public Club() {}
}