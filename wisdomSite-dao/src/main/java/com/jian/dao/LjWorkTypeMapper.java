package com.jian.dao;

import com.jian.entity.LjWorkType;
import com.jian.entity.LjWorkTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LjWorkTypeMapper {
    long countByExample(LjWorkTypeExample example);

    int deleteByExample(LjWorkTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(LjWorkType record);

    int insertSelective(LjWorkType record);

    List<LjWorkType> selectByExampleWithRowbounds(LjWorkTypeExample example, RowBounds rowBounds);

    List<LjWorkType> selectByExample(LjWorkTypeExample example);

    LjWorkType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LjWorkType record, @Param("example") LjWorkTypeExample example);

    int updateByExample(@Param("record") LjWorkType record, @Param("example") LjWorkTypeExample example);

    int updateByPrimaryKeySelective(LjWorkType record);

    int updateByPrimaryKey(LjWorkType record);
}