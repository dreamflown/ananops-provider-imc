package com.ananops.provider.model.domain;

import com.ananops.provider.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "imc_inspection_item_log")
public class ImcInspectionItemLog extends BaseEntity {
    private static final long serialVersionUID = 6726449370617399468L;

    /**
     * 对应的巡检任务ID
     */
    @Column(name = "task_id")
    private Long taskId;

    /**
     * 对应的状态类型
     */
    private Integer status;

    /**
     * 对应的时间戳
     */
    @Column(name = "status_timestamp")
    private Date statusTimestamp;

    /**
     * 当前操作的描述（有可能不存在）
     */
    private String movement;

    /**
     * 对应的巡检任务子项ID
     */
    @Column(name = "item_id")
    private Long itemId;
}