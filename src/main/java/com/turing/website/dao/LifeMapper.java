package com.turing.website.dao;

import com.turing.website.bean.Life;
import com.turing.website.bean.LifeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifeMapper {
    long countByExample(LifeExample example);

    int deleteByExample(LifeExample example);

    int deleteByPrimaryKey(Integer lifeId);

    int insert(Life record);

    int insertSelective(Life record);

    List<Life> selectByExample(LifeExample example);

    Life selectByPrimaryKey(Integer lifeId);

    int updateByExampleSelective(@Param("record") Life record, @Param("example") LifeExample example);

    int updateByExample(@Param("record") Life record, @Param("example") LifeExample example);

    int updateByPrimaryKeySelective(Life record);

    int updateByPrimaryKey(Life record);
}