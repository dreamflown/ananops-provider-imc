package com.ananops.provider.service.impl;

import com.ananops.provider.mapper.ImcInspectionItemLogMapper;
import com.ananops.provider.model.domain.ImcInspectionItemLog;
import com.ananops.provider.service.ImcInspectionItemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by rongshuai on 2019/11/28 15:31
 */
@Service
public class ImcInspectionItemLogServiceImpl implements ImcInspectionItemLogService {
    @Resource
    ImcInspectionItemLogMapper imcInspectionItemLogMapper;

    public Integer createInspectionItemLog(ImcInspectionItemLog imcInspectionItemLog){
        return imcInspectionItemLogMapper.insert(imcInspectionItemLog);
    }
}
