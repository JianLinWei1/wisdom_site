package com.jian.dao;

import com.jian.entity.LjCardInfo;
import com.jian.entity.LjCardInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LjCardInfoMapper {
    long countByExample(LjCardInfoExample example);

    int deleteByExample(LjCardInfoExample example);

    int deleteByPrimaryKey(String idCard);

    int insert(LjCardInfo record);

    int insertSelective(LjCardInfo record);

    List<LjCardInfo> selectByExampleWithRowbounds(LjCardInfoExample example, RowBounds rowBounds);

    List<LjCardInfo> selectByExample(LjCardInfoExample example);

    LjCardInfo selectByPrimaryKey(String idCard);

    int updateByExampleSelective(@Param("record") LjCardInfo record, @Param("example") LjCardInfoExample example);

    int updateByExample(@Param("record") LjCardInfo record, @Param("example") LjCardInfoExample example);

    int updateByPrimaryKeySelective(LjCardInfo record);

    int updateByPrimaryKey(LjCardInfo record);
}