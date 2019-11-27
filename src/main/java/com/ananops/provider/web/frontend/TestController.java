package com.ananops.provider.web.frontend;

import com.ananops.provider.model.domain.ImcDeviceOrder;
import com.ananops.provider.service.ImcDeviceOrderService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by rongshuai on 2019/11/27 10:21
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Resource
    ImcDeviceOrderService imcDeviceOrderService;

    @RequestMapping(value = "hello",method = RequestMethod.POST)
    @ResponseBody
    public String SayHello(@RequestBody String Message){
        JsonObject jsonObject = (JsonObject)new JsonParser().parse(Message);
        String device_type =jsonObject.get("device_type").getAsString();
        ImcDeviceOrder imcDeviceOrder = new ImcDeviceOrder(device_type);
        System.out.println(device_type);
        System.out.println(imcDeviceOrder.toString());
        Integer result = imcDeviceOrderService.insertRecord(imcDeviceOrder);
        return result.toString();
    }
}
