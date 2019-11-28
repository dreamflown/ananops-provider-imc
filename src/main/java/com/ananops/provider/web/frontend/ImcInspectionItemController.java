package com.ananops.provider.web.frontend;

import com.ananops.provider.model.domain.ImcInspectionItem;
import com.ananops.provider.model.dto.ImcAddInspectionItemDto;
import com.ananops.provider.model.dto.ImcAddInspectionTaskDto;
import com.ananops.provider.service.ImcInspectionItemService;
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
 * Created by rongshuai on 2019/11/28 10:10
 */
@RestController
@RequestMapping(value = "/inspectionItem",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - ImcInspectionItemService",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ImcInspectionItemController {
    @Resource
    ImcInspectionItemService imcInspectionItemService;

    @PostMapping(value = "/save")
    @ApiOperation(httpMethod = "POST",value = "新增一条巡检任务子项记录")
    public Wrapper<String> saveInspectionItem(@ApiParam(name = "saveInspectionItem",value = "新增一条巡检任务子项记录")@RequestBody ImcAddInspectionItemDto imcAddInspectionItemDto){
        ImcInspectionItem imcInspectionItem = new ImcInspectionItem();
        BeanUtils.copyProperties(imcAddInspectionItemDto,imcInspectionItem);
        imcInspectionItemService.addInspectionItem(imcInspectionItem);
        return WrapMapper.ok("巡检任务子项创建成功");
    }

    @PostMapping(value = "/modifyDeviceStatus/{itemId}/{deviceStatus}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应的设备状态")
    public Wrapper<String> modifyDeviceStatus(@PathVariable Long itemId,@PathVariable Integer deviceStatus){
        imcInspectionItemService.modifyDeviceStatusByItemId(itemId,deviceStatus);
        return WrapMapper.ok("修改巡检任务子项对应的设备状态成功");
    }

    @PostMapping(value = "/setExceptionDescription/{itemId}/{exceptionDescription}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应的设备异常描述")
    public Wrapper<String> setExceptionDescription(@PathVariable Long itemId,@PathVariable String exceptionDescription){
        imcInspectionItemService.setExceptionDescriptionByItemId(itemId,exceptionDescription);
        return WrapMapper.ok("修改巡检任务子项对应的设备异常描述成功");
    }

    @PostMapping(value = "/setExceptionLevel/{itemId}/{exceptionLevel}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应的设备异常等级")
    public Wrapper<String> setExceptionLevel(@PathVariable Long itemId,@PathVariable Integer exceptionLevel){
        imcInspectionItemService.setExceptionLevelByItemId(itemId,exceptionLevel);
        return WrapMapper.ok("修改巡检任务子项对应的设备异常等级成功");
    }

    @PostMapping(value = "/updateScheduledStartTime/{itemId}/{schduledStartTime}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应计划开始时间")
    public Wrapper<String> updateScheduledStartTime(@PathVariable Long itemId,@PathVariable Date schduledStartTime){
        imcInspectionItemService.updateScheduledStartTimeByItemId(itemId,schduledStartTime);
        return WrapMapper.ok("修改巡检任务子项对应的计划开始时间成功");
    }

    @PostMapping(value = "/updateActualStartTime/{itemId}/{actualStartTime}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应实际开始时间")
    public Wrapper<String> updateActualStartTime(@PathVariable Long itemId,@PathVariable Date actualStartTime){
        imcInspectionItemService.updateActualStartTimeByItemId(itemId,actualStartTime);
        return WrapMapper.ok("修改巡检任务子项对应的实际开始时间成功");
    }

    @PostMapping(value = "/updateScheduledFinishTime/{itemId}/{scheduledFinishTime}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应计划完成时间")
    public Wrapper<String> updateScheduledFinishTime(@PathVariable Long itemId,@PathVariable Date scheduledFinishTime){
        imcInspectionItemService.updateScheduledFinishTimeByItemId(itemId,scheduledFinishTime);
        return WrapMapper.ok("修改巡检任务子项对应的实计划完成时间成功");
    }

    @PostMapping(value = "/updateActualFinishTime/{itemId}/{actualFinishTime}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应实际完成时间")
    public Wrapper<String> updateActualFinishTime(@PathVariable Long itemId,@PathVariable Date actualFinishTime){
        imcInspectionItemService.updateActualFinishTimeByItemId(itemId,actualFinishTime);
        return WrapMapper.ok("修改巡检任务子项对应的实际完成时间成功");
    }

    @PostMapping(value = "/setMaintenanceTaskId/{itemId}/{maintenanceTaskId}")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务子项对应维修任务ID")
    public Wrapper<String> setMaintenanceTaskId(@PathVariable Long itemId,@PathVariable Long maintenanceTaskId){
        imcInspectionItemService.setMaintenanceTaskIdByItemId(itemId,maintenanceTaskId);
        return WrapMapper.ok("修改巡检任务子项对应维修任务ID成功");
    }

    @PostMapping(value = "/updateDescription/{itemId}/{description}")
    @ApiOperation(httpMethod = "POST",value = "更新巡检任务子项对应描述信息")
    public Wrapper<String> updateDescription(@PathVariable Long itemId,@PathVariable String description){
        imcInspectionItemService.updateDescriptionByItemId(itemId,description);
        return WrapMapper.ok("更新巡检任务子项对应描述信息成功");
    }

    @PostMapping(value = "/modifyStatus/{itemId}/{status}")
    @ApiOperation(httpMethod = "POST",value = "更新巡检任务子项对应状态信息")
    public Wrapper<String> modifyStatus(@PathVariable Long itemId,@PathVariable Integer status){
        imcInspectionItemService.modifyStatusByItemId(itemId,status);
        return WrapMapper.ok("更新巡检任务子项对应状态信息成功");
    }

    @PostMapping(value = "/setDeviceLocation/{itemId}/{latitude}/{longitude}")
    @ApiOperation(httpMethod = "POST",value = "更新巡检任务子项对应的设备位置信息")
    public Wrapper<String> setDeviceLocation(@PathVariable Long itemId, @PathVariable BigDecimal latitude,@PathVariable BigDecimal longitude){
        imcInspectionItemService.setDeviceLocationByItemId(itemId,latitude,longitude);
        return WrapMapper.ok("更新巡检任务子项对应的设备位置信息成功");
    }
}
