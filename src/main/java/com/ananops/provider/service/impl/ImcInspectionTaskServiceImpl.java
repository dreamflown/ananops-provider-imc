package com.ananops.provider.service.impl;

import com.ananops.provider.mapper.ImcInspectionTaskMapper;
import com.ananops.provider.model.domain.ImcInspectionTask;
import com.ananops.provider.service.ImcInspectionTaskService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by rongshuai on 2019/11/27 19:31
 */
@Service
public class ImcInspectionTaskServiceImpl implements ImcInspectionTaskService {
    @Resource
    ImcInspectionTaskMapper imcInspectionTaskMapper;

    /**
     * 插入一条巡检任务记录
     * @param imcInspectionTask
     * @return
     */
    public Integer addTask(ImcInspectionTask imcInspectionTask){
        return imcInspectionTaskMapper.insert(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param facilitatorId
     * @return
     */
    public Integer setFacilitatorByTaskId(Long taskId,Long facilitatorId){//根据巡检任务ID，更新服务商ID
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setFacilitatorId(facilitatorId);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param status
     * @return
     */
    public Integer modifyTaskStatusByTaskId(Long taskId,Integer status){//根据巡检任务ID，更新服务商状态
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setStatus(status);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    public Integer setLocationByTaskId(Long taskId,String location){//根据巡检任务ID，设置当前巡检任务发出的地址
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setLocation(location);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param principalId
     * @return
     */
    public Integer setPrincipalIdByTaskId(Long taskId,Long principalId){//根据巡检任务ID，设置此次巡检对应的负责人ID
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setPrincipalId(principalId);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param projectId
     * @return
     */
    public Integer setProjectIdByTaskId(Long taskId,Long projectId){//根据巡检任务ID，设置当前巡检任务所属的项目
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setProjectId(projectId);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param scheduledStartTime
     * @return
     */
    public Integer setScheduledStartTimeByTaskId(Long taskId, Date scheduledStartTime){//根据当前任务的ID，配置任务的计划开始时间
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setScheduledStartTime(scheduledStartTime);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param scheduledFinishTime
     * @return
     */
    public Integer setScheduledFinishTimeByTaskId(Long taskId,Date scheduledFinishTime){//根据当前任务的ID，配置当前任务的计划结束时间
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setScheduledFinishTime(scheduledFinishTime);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param actualStartTime
     * @return
     */
    public Integer setActualStartTimeByTaskId(Long taskId,Date actualStartTime){//根据当前任务的ID，配置任务的实际开始时间
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setActualStartTime(actualStartTime);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param actualFinishedTime
     * @return
     */
    public Integer setActualFinishTimeByTaskId(Long taskId,Date actualFinishedTime){//根据当前任务的ID，配置任务的实际结束时间
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setActualFinishTime(actualFinishedTime);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param deadline
     * @return
     */
    public Integer setDeadlineByTaskId(Long taskId,Date deadline){//根据当前任务的ID，配置任务的最迟结束时间
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setDeadline(deadline);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param inspectionType
     * @return
     */
    public Integer setInspectionTypeByTaskId(Long taskId,Integer inspectionType){//根据当前任务的ID，配置任务的巡检类型（按不按合同）
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setInspectionType(inspectionType);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param remark
     * @return
     */
    public Integer updateRemarkByTaskId(Long taskId,String remark){//根据当前巡检任务的ID，更新甲方对此次巡检的备注
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setRemark(remark);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param totalCost
     * @return
     */
    public Integer updateTotalCostByTaskId(Long taskId, BigDecimal totalCost){//根据此次巡检任务的ID，更新此次巡检的总花费
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setTotalCost(totalCost);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }

    /**
     *
     * @param taskId
     * @param maintenanceCost
     * @return
     */
    public Integer updateMaintenanceCostByTaskId(Long taskId,BigDecimal maintenanceCost){//根据此次巡检任务的ID，更新此次巡检的维修花费
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<ImcInspectionTask> imcInspectionTasks = imcInspectionTaskMapper.selectByExample(example);
        ImcInspectionTask imcInspectionTask = imcInspectionTasks.get(0);
        imcInspectionTask.setMaintenanceCost(maintenanceCost);
        return imcInspectionTaskMapper.updateByPrimaryKey(imcInspectionTask);
    }
}
