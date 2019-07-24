package com.jian.dao;

import com.jian.entity.StrangerCaptureView;
import com.jian.entity.StrangerCaptureViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StrangerCaptureViewMapper {
    long countByExample(StrangerCaptureViewExample example);

    int deleteByExample(StrangerCaptureViewExample example);

    int insert(StrangerCaptureView record);

    int insertSelective(StrangerCaptureView record);

    List<StrangerCaptureView> selectByExampleWithRowbounds(StrangerCaptureViewExample example, RowBounds rowBounds);

    List<StrangerCaptureView> selectByExample(StrangerCaptureViewExample example);

    int updateByExampleSelective(@Param("record") StrangerCaptureView record, @Param("example") StrangerCaptureViewExample example);

    int updateByExample(@Param("record") StrangerCaptureView record, @Param("example") StrangerCaptureViewExample example);
}