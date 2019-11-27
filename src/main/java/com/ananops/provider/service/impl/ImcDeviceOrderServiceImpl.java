package com.ananops.provider.service.impl;

import com.ananops.provider.mapper.ImcDeviceOrderMapper;
import com.ananops.provider.model.domain.ImcDeviceOrder;
import com.ananops.provider.service.ImcDeviceOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by rongshuai on 2019/11/27 10:23
 */
@Service
public class ImcDeviceOrderServiceImpl implements ImcDeviceOrderService {
    @Resource
    private ImcDeviceOrderMapper imcDeviceOrderMapper;

    public Integer insertRecord(ImcDeviceOrder imcDeviceOrder){
        return imcDeviceOrderMapper.insert(imcDeviceOrder);
    }
}
