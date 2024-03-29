package com.ananops.provider.mapper;

import com.ananops.provider.base.MyMapper;
import com.ananops.provider.model.domain.ImcInspectionTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ImcInspectionTaskMapper extends MyMapper<ImcInspectionTask> {
}