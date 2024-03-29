package com.ananops.provider.model.domain;

import com.ananops.provider.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "imc_inspection_task_log")
public class ImcInspectionTaskLog extends BaseEntity {
    private static final long serialVersionUID = -4969087886687181499L;

    /**
     * 对应的巡检任务ID
     */
    @Column(name = "task_id")
    private Long taskId;

    /**
     * 当前任务状态
     */
    private Integer status;

    /**
     * 操作对应的时间戳
     */
    @Column(name = "status_timestamp")
    private Date statusTimestamp;

    /**
     * 当前操作对应的描述（有可能不存在）
     */
    private String movement;
}