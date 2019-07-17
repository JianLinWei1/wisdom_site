package com.jian.dao;

import com.jian.entity.LjWorkerCapture;
import com.jian.entity.LjWorkerCaptureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LjWorkerCaptureMapper {
    long countByExample(LjWorkerCaptureExample example);

    int deleteByExample(LjWorkerCaptureExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(LjWorkerCapture record);

    int insertSelective(LjWorkerCapture record);

    List<LjWorkerCapture> selectByExampleWithRowbounds(LjWorkerCaptureExample example, RowBounds rowBounds);

    List<LjWorkerCapture> selectByExample(LjWorkerCaptureExample example);

    LjWorkerCapture selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") LjWorkerCapture record, @Param("example") LjWorkerCaptureExample example);

    int updateByExample(@Param("record") LjWorkerCapture record, @Param("example") LjWorkerCaptureExample example);

    int updateByPrimaryKeySelective(LjWorkerCapture record);

    int updateByPrimaryKey(LjWorkerCapture record);
}