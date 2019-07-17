package com.jian.dao;

import com.jian.entity.LjWorkerInfo;
import com.jian.entity.LjWorkerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LjWorkerInfoMapper {
    long countByExample(LjWorkerInfoExample example);

    int deleteByExample(LjWorkerInfoExample example);

    int deleteByPrimaryKey(String idCard);

    int insert(LjWorkerInfo record);

    int insertSelective(LjWorkerInfo record);

    List<LjWorkerInfo> selectByExampleWithRowbounds(LjWorkerInfoExample example, RowBounds rowBounds);

    List<LjWorkerInfo> selectByExample(LjWorkerInfoExample example);

    LjWorkerInfo selectByPrimaryKey(String idCard);

    int updateByExampleSelective(@Param("record") LjWorkerInfo record, @Param("example") LjWorkerInfoExample example);

    int updateByExample(@Param("record") LjWorkerInfo record, @Param("example") LjWorkerInfoExample example);

    int updateByPrimaryKeySelective(LjWorkerInfo record);

    int updateByPrimaryKey(LjWorkerInfo record);
}