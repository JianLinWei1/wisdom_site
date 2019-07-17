package com.jian.dao;

import com.jian.entity.LjStrangerCapture;
import com.jian.entity.LjStrangerCaptureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LjStrangerCaptureMapper {
    long countByExample(LjStrangerCaptureExample example);

    int deleteByExample(LjStrangerCaptureExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(LjStrangerCapture record);

    int insertSelective(LjStrangerCapture record);

    List<LjStrangerCapture> selectByExampleWithRowbounds(LjStrangerCaptureExample example, RowBounds rowBounds);

    List<LjStrangerCapture> selectByExample(LjStrangerCaptureExample example);

    LjStrangerCapture selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") LjStrangerCapture record, @Param("example") LjStrangerCaptureExample example);

    int updateByExample(@Param("record") LjStrangerCapture record, @Param("example") LjStrangerCaptureExample example);

    int updateByPrimaryKeySelective(LjStrangerCapture record);

    int updateByPrimaryKey(LjStrangerCapture record);
}