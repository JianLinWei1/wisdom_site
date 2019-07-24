package com.jian.dao;

import com.jian.entity.WorkerCaptureView;
import com.jian.entity.WorkerCaptureViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WorkerCaptureViewMapper {
    long countByExample(WorkerCaptureViewExample example);

    int deleteByExample(WorkerCaptureViewExample example);

    int insert(WorkerCaptureView record);

    int insertSelective(WorkerCaptureView record);

    List<WorkerCaptureView> selectByExampleWithRowbounds(WorkerCaptureViewExample example, RowBounds rowBounds);

    List<WorkerCaptureView> selectByExample(WorkerCaptureViewExample example);

    int updateByExampleSelective(@Param("record") WorkerCaptureView record, @Param("example") WorkerCaptureViewExample example);

    int updateByExample(@Param("record") WorkerCaptureView record, @Param("example") WorkerCaptureViewExample example);
}