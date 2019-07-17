package com.jian.dao;

import com.jian.entity.WorkerCardInfoView;
import com.jian.entity.WorkerCardInfoViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WorkerCardInfoViewMapper {
    long countByExample(WorkerCardInfoViewExample example);

    int deleteByExample(WorkerCardInfoViewExample example);

    int insert(WorkerCardInfoView record);

    int insertSelective(WorkerCardInfoView record);

    List<WorkerCardInfoView> selectByExampleWithRowbounds(WorkerCardInfoViewExample example, RowBounds rowBounds);

    List<WorkerCardInfoView> selectByExample(WorkerCardInfoViewExample example);

    int updateByExampleSelective(@Param("record") WorkerCardInfoView record, @Param("example") WorkerCardInfoViewExample example);

    int updateByExample(@Param("record") WorkerCardInfoView record, @Param("example") WorkerCardInfoViewExample example);
}