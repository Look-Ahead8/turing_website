package com.turing.website.dao;

import com.turing.website.bean.LifePirture;
import com.turing.website.bean.LifePirtureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifePirtureMapper {
    long countByExample(LifePirtureExample example);

    int deleteByExample(LifePirtureExample example);

    int deleteByPrimaryKey(Integer lpId);

    int insert(LifePirture record);

    int insertSelective(LifePirture record);

    List<LifePirture> selectByExample(LifePirtureExample example);

    LifePirture selectByPrimaryKey(Integer lpId);

    int updateByExampleSelective(@Param("record") LifePirture record, @Param("example") LifePirtureExample example);

    int updateByExample(@Param("record") LifePirture record, @Param("example") LifePirtureExample example);

    int updateByPrimaryKeySelective(LifePirture record);

    int updateByPrimaryKey(LifePirture record);
}