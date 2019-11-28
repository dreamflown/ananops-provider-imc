package com.ananops.provider.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rongshuai on 2019/11/28 10:18
 */
@Data
@ApiModel
public class ImcAddInspectionItemDto implements Serializable {
    private static final long serialVersionUID = -3159670420426980074L;
    /**
     * 被巡检的设备ID
     */
    @ApiModelProperty(value = "被巡检的设备ID")
    private Long deviceId;

    /**
     * 任务子项对应的任务ID
     */
    @ApiModelProperty(value = "任务子项对应的任务ID")
    private Long inspectionTaskId;

    /**
     * 被巡检的设备当前的状态
     */
    @ApiModelProperty(value = "被巡检的设备当前的状态")
    private Integer deviceStatus;

    /**
     * 当前巡检任务子项的状态
     */
    @ApiModelProperty(value = "当前巡检任务子项的状态")
    private Integer status;

    /**
     * 被巡检设备的位置，纬度
     */
    @ApiModelProperty(value = "被巡检设备的位置，纬度")
    private BigDecimal deviceLatitude;

    /**
     * 被巡检设备的位置，经度
     */
    @ApiModelProperty(value = "被巡检设备的位置，经度")
    private BigDecimal deviceLongitude;

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

    /**
     * 设备类型
     */
    @ApiModelProperty(value = "设备类型")
    private String deviceType;

}
