package com.ananops.provider.service;

import com.ananops.provider.model.domain.ImcInspectionItemLog;

/**
 * Created by rongshuai on 2019/11/28 15:31
 */
public interface ImcInspectionItemLogService {
    Integer createInspectionItemLog(ImcInspectionItemLog imcInspectionItemLog);//创建一条巡检任务子项日志
}