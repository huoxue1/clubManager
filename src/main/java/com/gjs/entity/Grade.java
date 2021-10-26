package com.gjs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @description grade
 * @author zhengkai.blog.csdn.net
 * @date 2021-10-04
 */
@Data
@ApiModel("grade")
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * grade_id
     */
    @ApiModelProperty("grade_id")
    private Integer gradeId;

    /**
     * grade_name
     */
    @ApiModelProperty("grade_name")
    private String gradeName;

}
