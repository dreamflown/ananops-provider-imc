package com.ananops.provider.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rongshuai on 2019/11/27 19:39
 */
@Data
@ApiModel
public class ImcAddInspectionTaskDto implements Serializable {
    private static final long serialVersionUID = -6922470629930578506L;
    /**
     * 甲方负责人ID
     */
    @ApiModelProperty(value = "甲方负责人ID")
    private Long principalId;

    /**
     * 服务商ID
     */
    @ApiModelProperty(value = "服务商ID")
    private Long facilitatorId;

    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID")
    private Long projectId;

    /**
     * 甲方位置信息
     */
    @ApiModelProperty(value = "甲方位置信息")
    private String location;

    /**
     * 任务当前状态
     */
    @ApiModelProperty(value = "任务当前状态")
    private Integer status;

    /**
     * 计划开始时间
     */
    @ApiModelProperty(value = "计划开始时间")
    private Date scheduledStartTime;

    /**
     * 计划完成时间
     */
    @ApiModelProperty(value = "计划完成时间")
    private Date scheduledFinishTime;

    /**
     * 最迟完成时间
     */
    @ApiModelProperty(value = "最迟完成时间")
    private Date deadline;

}
