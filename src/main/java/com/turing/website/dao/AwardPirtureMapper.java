package com.turing.website.dao;

import com.turing.website.bean.AwardPirture;
import com.turing.website.bean.AwardPirtureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwardPirtureMapper {
    long countByExample(AwardPirtureExample example);

    int deleteByExample(AwardPirtureExample example);

    int deleteByPrimaryKey(Integer apId);

    int insert(AwardPirture record);

    int insertSelective(AwardPirture record);

    List<AwardPirture> selectByExample(AwardPirtureExample example);

    AwardPirture selectByPrimaryKey(Integer apId);

    int updateByExampleSelective(@Param("record") AwardPirture record, @Param("example") AwardPirtureExample example);

    int updateByExample(@Param("record") AwardPirture record, @Param("example") AwardPirtureExample example);

    int updateByPrimaryKeySelective(AwardPirture record);

    int updateByPrimaryKey(AwardPirture record);
}