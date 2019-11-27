package com.ananops.provider.service;

import com.ananops.provider.model.domain.ImcInspectionTask;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rongshuai on 2019/11/27 19:29
 */
public interface ImcInspectionTaskService {
    Integer addTask(ImcInspectionTask imcInspectionTask);//创建一条巡检任务

    Integer setFacilitatorByTaskId(Long taskId,Long facilitatorId);//为当前巡检任务指定服务商

    Integer modifyTaskStatusByTaskId(Long taskId,Integer status);//修改当前巡检任务的状态

    Integer setLocationByTaskId(Long taskId,String location);//设置当前巡检任务的发出地址

    Integer setPrincipalIdByTaskId(Long taskId,Long principalId);//设置当前巡检任务的负责人ID

    Integer setProjectIdByTaskId(Long taskId,Long projectId);//设置当前巡检任务所属的项目ID

    Integer setScheduledStartTimeByTaskId(Long taskId, Date scheduledStartTime);//设置当前巡检任务的计划开始时间

    Integer setScheduledFinishTimeByTaskId(Long taskId,Date scheduledFinishTime);//根据当前任务的ID，配置当前任务的计划结束时间

    Integer setActualStartTimeByTaskId(Long taskId,Date actualStartTime);//根据当前任务的ID，配置任务的实际开始时间

    Integer setActualFinishTimeByTaskId(Long taskId,Date actualFinishedTime);//根据当前任务的ID，配置任务的实际结束时间

    Integer setDeadlineByTaskId(Long taskId,Date deadline);//根据当前任务的ID，配置任务的最迟结束时间

    Integer setInspectionTypeByTaskId(Long taskId,Integer inspectionType);//根据当前任务的ID，配置任务的巡检类型（按不按合同）

    Integer updateRemarkByTaskId(Long taskId,String remark);//根据当前巡检任务的ID，更新甲方对此次巡检的备注

    Integer updateTotalCostByTaskId(Long taskId, BigDecimal totalCost);//根据此次巡检任务的ID，更新此次巡检的总花费

    Integer updateMaintenanceCostByTaskId(Long taskId,BigDecimal maintenanceCost);//根据此次巡检任务的ID，更新此次巡检的维修花费



}
