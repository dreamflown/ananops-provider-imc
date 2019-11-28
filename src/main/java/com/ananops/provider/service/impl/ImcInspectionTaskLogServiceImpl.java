package com.ananops.provider.service.impl;

import com.ananops.provider.mapper.ImcInspectionTaskLogMapper;
import com.ananops.provider.model.domain.ImcInspectionTaskLog;
import com.ananops.provider.service.ImcInspectionTaskLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by rongshuai on 2019/11/28 15:30
 */
@Service
public class ImcInspectionTaskLogServiceImpl implements ImcInspectionTaskLogService {
    @Resource
    ImcInspectionTaskLogMapper imcInspectionTaskLogMapper;

    public Integer createInspectionTaskLog(ImcInspectionTaskLog imcInspectionTaskLog){//创建一条巡检任务的日志
        return imcInspectionTaskLogMapper.insert(imcInspectionTaskLog);
    }
}
