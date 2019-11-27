package com.ananops.provider.web.frontend;

import com.ananops.provider.model.domain.ImcDeviceOrder;
import com.ananops.provider.service.ImcDeviceOrderService;
import com.ananops.provider.utils.WrapMapper;
import com.ananops.provider.utils.Wrapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by rongshuai on 2019/11/27 10:21
 */
@RestController
@RequestMapping(value = "/test",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - ImcTest",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {
    @Resource
    ImcDeviceOrderService imcDeviceOrderService;

    @PostMapping(value = "/hello")
    @ApiOperation(httpMethod = "POST",value = "测试")
    public Wrapper<String> SayHello(@ApiParam(name = "test",value = "测试") @RequestBody String Message){
        JsonObject jsonObject = (JsonObject)new JsonParser().parse(Message);
        String device_type =jsonObject.get("device_type").getAsString();
        ImcDeviceOrder imcDeviceOrder = new ImcDeviceOrder(device_type);
        System.out.println(device_type);
        System.out.println(imcDeviceOrder.toString());
        Integer result = imcDeviceOrderService.insertRecord(imcDeviceOrder);
        return WrapMapper.ok(result.toString());
    }
}
