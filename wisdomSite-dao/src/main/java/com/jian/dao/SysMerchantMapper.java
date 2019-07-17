package com.jian.dao;

import com.jian.entity.SysMerchant;
import com.jian.entity.SysMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysMerchantMapper {
    long countByExample(SysMerchantExample example);

    int deleteByExample(SysMerchantExample example);

    int deleteByPrimaryKey(String belongId);

    int insert(SysMerchant record);

    int insertSelective(SysMerchant record);

    List<SysMerchant> selectByExampleWithRowbounds(SysMerchantExample example, RowBounds rowBounds);

    List<SysMerchant> selectByExample(SysMerchantExample example);

    SysMerchant selectByPrimaryKey(String belongId);

    int updateByExampleSelective(@Param("record") SysMerchant record, @Param("example") SysMerchantExample example);

    int updateByExample(@Param("record") SysMerchant record, @Param("example") SysMerchantExample example);

    int updateByPrimaryKeySelective(SysMerchant record);

    int updateByPrimaryKey(SysMerchant record);
}