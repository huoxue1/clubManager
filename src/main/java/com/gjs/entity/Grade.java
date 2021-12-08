package com.gjs.entity;

import java.io.Serializable;

/**
 * 班级(Grade)实体类
 *
 * @author makejava
 * @since 2021-11-01 14:48:54
 */
public class Grade implements Serializable {
    private static final long serialVersionUID = 848230114568001424L;

    private Integer gradeId;

    private String gradeName;


    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

}

