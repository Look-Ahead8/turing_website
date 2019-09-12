package com.turing.website.dao;

import com.turing.website.bean.ProjectPirture;
import com.turing.website.bean.ProjectPirtureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectPirtureMapper {
    long countByExample(ProjectPirtureExample example);

    int deleteByExample(ProjectPirtureExample example);

    int deleteByPrimaryKey(Integer ppId);

    int insert(ProjectPirture record);

    int insertSelective(ProjectPirture record);

    List<ProjectPirture> selectByExample(ProjectPirtureExample example);

    ProjectPirture selectByPrimaryKey(Integer ppId);

    int updateByExampleSelective(@Param("record") ProjectPirture record, @Param("example") ProjectPirtureExample example);

    int updateByExample(@Param("record") ProjectPirture record, @Param("example") ProjectPirtureExample example);

    int updateByPrimaryKeySelective(ProjectPirture record);

    int updateByPrimaryKey(ProjectPirture record);
}