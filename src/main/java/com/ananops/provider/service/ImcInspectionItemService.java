package com.ananops.provider.service;

import com.ananops.provider.model.domain.ImcInspectionItem;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rongshuai on 2019/11/28 10:13
 */
public interface ImcInspectionItemService {
    Integer addInspectionItem(ImcInspectionItem imcInspectionItem);//新增一条巡检子项记录

    Integer modifyDeviceStatusByItemId(Long itemId,Integer deviceStatus);//修改被巡检设备的状态

    Integer setExceptionDescriptionByItemId(Long itemId,String exceptionDescription);//设置巡检子项的异常描述

    Integer setExceptionLevelByItemId(Long itemId,Integer exceptionLevel);//设置巡检任务子项对应的异常等级

    Integer updateScheduledStartTimeByItemId(Long itemId, Date scheduledStartTime);//更新巡检任务子项的计划开始时间

    Integer updateActualStartTimeByItemId(Long itemId,Date actualStartTime);//更新巡检任务子项的实际开始时间

    Integer updateScheduledFinishTimeByItemId(Long itemId,Date scheduledFinishTime);//更新巡检任务子项的计划完成时间

    Integer updateActualFinishTimeByItemId(Long itemId,Date actualFinishTime);//更新选件任务子项的实际结束时间

    Integer setMaintenanceTaskIdByItemId(Long itemId,Long maintenanceTaskId);//设置当前巡检任务子项对应的维修维护任务Id

    Integer updateDescriptionByItemId(Long itemId,String description);//更新巡检任务子项目的描述信息

    Integer modifyStatusByItemId(Long itemId,Integer status);//修改当前巡检任务子项的状态

    Integer setDeviceLocationByItemId(Long itemId, BigDecimal deviceLatitude, BigDecimal deviceLongitude);//设置当前任务子项对应的设备位置信息
}
