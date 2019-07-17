package com.jian.dao;

import com.jian.entity.LjDevice;
import com.jian.entity.LjDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LjDeviceMapper {
    long countByExample(LjDeviceExample example);

    int deleteByExample(LjDeviceExample example);

    int deleteByPrimaryKey(String deviceSeril);

    int insert(LjDevice record);

    int insertSelective(LjDevice record);

    List<LjDevice> selectByExampleWithRowbounds(LjDeviceExample example, RowBounds rowBounds);

    List<LjDevice> selectByExample(LjDeviceExample example);

    LjDevice selectByPrimaryKey(String deviceSeril);

    int updateByExampleSelective(@Param("record") LjDevice record, @Param("example") LjDeviceExample example);

    int updateByExample(@Param("record") LjDevice record, @Param("example") LjDeviceExample example);

    int updateByPrimaryKeySelective(LjDevice record);

    int updateByPrimaryKey(LjDevice record);
}