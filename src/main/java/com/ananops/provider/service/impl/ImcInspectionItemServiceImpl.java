package com.ananops.provider.service.impl;

import com.ananops.provider.mapper.ImcInspectionItemMapper;
import com.ananops.provider.model.domain.ImcInspectionItem;
import com.ananops.provider.model.domain.ImcInspectionTask;
import com.ananops.provider.service.ImcInspectionItemService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by rongshuai on 2019/11/28 10:14
 */
@Service
public class ImcInspectionItemServiceImpl implements ImcInspectionItemService {
    @Resource
    private ImcInspectionItemMapper imcInspectionItemMapper;

    /**
     *
     * @param imcInspectionItem
     * @return
     */
    public Integer addInspectionItem(ImcInspectionItem imcInspectionItem){//创建一条巡检任务子项记录
        return imcInspectionItemMapper.insert(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param deviceStatus
     * @return
     */
    public Integer modifyDeviceStatusByItemId(Long itemId,Integer deviceStatus){//修改被巡检设备的状态
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setDeviceStatus(deviceStatus);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param exceptionDescription
     * @return
     */
    public Integer setExceptionDescriptionByItemId(Long itemId,String exceptionDescription){//设置巡检子项的异常描述
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setExceptionDescription(exceptionDescription);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param exceptionLevel
     * @return
     */
    public Integer setExceptionLevelByItemId(Long itemId,Integer exceptionLevel){//设置巡检任务子项对应的异常等级
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setExceptionLevel(exceptionLevel);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param scheduledStartTime
     * @return
     */
    public Integer updateScheduledStartTimeByItemId(Long itemId, Date scheduledStartTime){//更新巡检任务子项的计划开始时间
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setScheduledStartTime(scheduledStartTime);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param actualStartTime
     * @return
     */
    public Integer updateActualStartTimeByItemId(Long itemId,Date actualStartTime){//更新巡检任务子项的实际开始时间
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setActualStartTime(actualStartTime);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param scheduledFinishTime
     * @return
     */
    public Integer updateScheduledFinishTimeByItemId(Long itemId,Date scheduledFinishTime){//更新巡检任务子项的计划完成时间
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setScheduledFinishTime(scheduledFinishTime);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param actualFinishTime
     * @return
     */
    public Integer updateActualFinishTimeByItemId(Long itemId,Date actualFinishTime){//更新选件任务子项的实际结束时间
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setActualFinishTime(actualFinishTime);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param maintenanceTaskId
     * @return
     */
    public Integer setMaintenanceTaskIdByItemId(Long itemId,Long maintenanceTaskId){//设置当前巡检任务子项对应的维修维护任务Id
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setMaintenanceTaskId(maintenanceTaskId);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param description
     * @return
     */
    public Integer updateDescriptionByItemId(Long itemId,String description){//更新巡检任务子项目的描述信息
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setDescription(description);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param status
     * @return
     */
    public Integer modifyStatusByItemId(Long itemId,Integer status){//修改当前巡检任务子项的状态
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setStatus(status);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    /**
     *
     * @param itemId
     * @param deviceLatitude
     * @param deviceLongitude
     * @return
     */
    public Integer setDeviceLocationByItemId(Long itemId, BigDecimal deviceLatitude,BigDecimal deviceLongitude){//设置当前任务子项对应的设备位置信息
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        List<ImcInspectionItem> imcInspectionItems = imcInspectionItemMapper.selectByExample(example);
        ImcInspectionItem imcInspectionItem = imcInspectionItems.get(0);
        imcInspectionItem.setDeviceLatitude(deviceLatitude);
        imcInspectionItem.setDeviceLongitude(deviceLongitude);
        return imcInspectionItemMapper.updateByPrimaryKey(imcInspectionItem);
    }

    public Integer setBasicInfoFromContract(){//将从合同中获取到的基本信息填写到巡检任务中
        return 1;
    }
}
