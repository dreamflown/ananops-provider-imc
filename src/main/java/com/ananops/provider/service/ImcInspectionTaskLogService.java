package com.ananops.provider.service;

import com.ananops.provider.model.domain.ImcInspectionTaskLog;

/**
 * Created by rongshuai on 2019/11/28 15:29
 */
public interface ImcInspectionTaskLogService {
    Integer createInspectionTaskLog(ImcInspectionTaskLog imcInspectionTaskLog);//创建一条巡检任务的日志
}
