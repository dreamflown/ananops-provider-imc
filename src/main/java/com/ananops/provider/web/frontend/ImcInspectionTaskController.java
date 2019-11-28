package com.ananops.provider.web.frontend;

import com.ananops.provider.model.domain.ImcInspectionTask;
import com.ananops.provider.model.dto.ImcAddInspectionTaskDto;
import com.ananops.provider.service.ImcInspectionTaskService;
import com.ananops.provider.utils.WrapMapper;
import com.ananops.provider.utils.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rongshuai on 2019/11/27 19:28
 */
@RestController
@RequestMapping(value = "/inspectionTask",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - ImcInspectionTask",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ImcInspectionTaskController {
    @Resource
    ImcInspectionTaskService imcInspectionTaskService;

    @PostMapping(value = "/save")
    @ApiOperation(httpMethod = "POST",value = "新增一条巡检任务记录")
    public Wrapper<String> saveInspectionTask(@ApiParam(name = "saveInspectionTask",value = "新增一条巡检任务记录")@RequestBody ImcAddInspectionTaskDto imcAddInspectionTaskDto){
        ImcInspectionTask imcInspectionTask = new ImcInspectionTask();
        BeanUtils.copyProperties(imcAddInspectionTaskDto,imcInspectionTask);//根据合同的信息填充巡检工单的基本信息
        imcInspectionTaskService.addTask(imcInspectionTask);
        return WrapMapper.ok("巡检任务创建成功");
    }

    @PostMapping(value = "/updateFacilitatorId/{taskId}/{facilitatorId}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，更新任务的服务商ID")
    public Wrapper<String> updateFaclitatorIdByTaskId(@PathVariable Long taskId,@PathVariable Long facilitatorId){
        imcInspectionTaskService.setFacilitatorByTaskId(taskId,facilitatorId);
        return WrapMapper.ok("更新巡检任务的服务商ID成功");
    }

    @PostMapping(value = "/modifyTaskStatus/{taskId}/{status}")
    @ApiOperation(httpMethod = "POST",value = "根据任务ID，更新任务的当前状态")
    public Wrapper<String> modifyTaskStatusByTaskId(@PathVariable Long taskId,@PathVariable Integer status){
        imcInspectionTaskService.modifyTaskStatusByTaskId(taskId,status);
        return WrapMapper.ok("更新巡检任务当前的状态");
    }

    @PostMapping(value = "/setTaskLocation/{taskId}/{location}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务的发出地址")
    public Wrapper<String> setTaskLocationByTaskId(@PathVariable Long taskId,@PathVariable String location){
        imcInspectionTaskService.setLocationByTaskId(taskId,location);
        return WrapMapper.ok("设置巡检任务发出的位置成功");
    }

    @PostMapping(value = "/setTaskPrincipal/{taskId}/{principalId}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务的负责人ID")
    public Wrapper<String> setTaskPrincipalIdByTaskId(@PathVariable Long taskId,@PathVariable Long principalId){
        imcInspectionTaskService.setPrincipalIdByTaskId(taskId,principalId);
        return WrapMapper.ok("设置巡检任务的负责人成功");
    }

    @PostMapping(value = "/setTaskProject/{taskId}/{projectId}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务所属的项目ID")
    public Wrapper<String> setTaskProjectByTaskId(@PathVariable Long taskId,@PathVariable Long projectId){
        imcInspectionTaskService.setProjectIdByTaskId(taskId,projectId);
        return WrapMapper.ok("设置巡检任务从属的项目成功");
    }

    @PostMapping(value = "/setScheduledStartTime/{taskId}/{scheduledStartTime}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务的预计开始时间")
    public Wrapper<String> setScheduledStartTimeByTaskId(@PathVariable Long taskId, @PathVariable Long scheduledStartTime){
        Date time = new Date(scheduledStartTime*1000);
        imcInspectionTaskService.setScheduledStartTimeByTaskId(taskId,time);
        return WrapMapper.ok("设置巡检任务的计划起始时间成功");
    }

    @PostMapping(value = "/setScheduledFinishTime/{taskId}/{scheduledFinishTime}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务的预计完成时间")
    public Wrapper<String> setScheduledFinishTimeByTaskId(@PathVariable Long taskId, @PathVariable Long scheduledFinishTime){
        Date time = new Date(scheduledFinishTime*1000);
        imcInspectionTaskService.setScheduledFinishTimeByTaskId(taskId,time);
        return WrapMapper.ok("设置巡检任务的计划完成时间成功");
    }

    @PostMapping(value = "/setActualStartTime/{taskId}/{actualStartTime}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务的实际开始时间")
    public Wrapper<String> setActualStartTimeByTaskId(@PathVariable Long taskId, @PathVariable Long actualStartTime){
        Date time = new Date(actualStartTime*1000);
        imcInspectionTaskService.setActualStartTimeByTaskId(taskId,time);
        return WrapMapper.ok("设置巡检任务的实际起始时间成功");
    }

    @PostMapping(value = "/setActualFinishTime/{taskId}/{actualFinishTime}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务的实际结束时间")
    public Wrapper<String> setActualFinishTimeByTaskId(@PathVariable Long taskId, @PathVariable Long actualFinishTime){
        Date time = new Date(actualFinishTime*1000);
        imcInspectionTaskService.setActualFinishTimeByTaskId(taskId,time);
        return WrapMapper.ok("设置巡检任务的实际完成时间成功");
    }

    @PostMapping(value = "/setDeadline/{taskId}/{deadline}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务最迟结束时间")
    public Wrapper<String> setDeadlineByTaskId(@PathVariable Long taskId, @PathVariable Long deadline){
        Date time = new Date(deadline*1000);
        imcInspectionTaskService.setDeadlineByTaskId(taskId,time);
        return WrapMapper.ok("设置巡检任务的最迟完成时间成功");
    }

    @PostMapping(value = "/setInspectionType/{taskId}/{inspectionType}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，配置当前任务的巡检类型")
    public Wrapper<String> setInspectionTypeByTaskId(@PathVariable Long taskId, @PathVariable Integer inspectionType){
        imcInspectionTaskService.setInspectionTypeByTaskId(taskId,inspectionType);
        return WrapMapper.ok("设置巡检任务的巡检类型成功");
    }

    @PostMapping(value = "/updateRemark/{taskId}/{remark}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，更新当前任务的备注")
    public Wrapper<String> updateRemarkByTaskId(@PathVariable Long taskId, @PathVariable String remark){
        imcInspectionTaskService.updateRemarkByTaskId(taskId,remark);
        return WrapMapper.ok("更新巡检任务的备注成功");
    }

    @PostMapping(value = "/updateTotalCost/{taskId}/{totalCost}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，更新当前任务的总花费")
    public Wrapper<String> updateTotalCostByTaskId(@PathVariable Long taskId, @PathVariable BigDecimal totalCost){
        imcInspectionTaskService.updateTotalCostByTaskId(taskId,totalCost);
        return WrapMapper.ok("更新巡检任务的总花费成功");
    }

    @PostMapping(value = "/updateMaintenanceCost/{taskId}/{maintenanceCost}")
    @ApiOperation(httpMethod = "POST",value = "根据任务的ID，更新当前任务的维修维护花费")
    public Wrapper<String> updateMaintenanceCostByTaskId(@PathVariable Long taskId, @PathVariable BigDecimal maintenanceCost){
        imcInspectionTaskService.updateMaintenanceCostByTaskId(taskId,maintenanceCost);
        return WrapMapper.ok("更新巡检任务的维修维护花费成功");
    }
}
