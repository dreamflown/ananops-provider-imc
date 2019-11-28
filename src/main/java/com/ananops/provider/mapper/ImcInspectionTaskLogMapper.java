package com.ananops.provider.mapper;

import com.ananops.provider.base.MyMapper;
import com.ananops.provider.model.domain.ImcInspectionTaskLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;
@Mapper
@Component
public interface ImcInspectionTaskLogMapper extends MyMapper<ImcInspectionTaskLog> {
}