package com.turing.website.dao;

import com.turing.website.bean.MemberRole;
import com.turing.website.bean.MemberRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberRoleMapper {
    long countByExample(MemberRoleExample example);

    int deleteByExample(MemberRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberRole record);

    int insertSelective(MemberRole record);

    List<MemberRole> selectByExample(MemberRoleExample example);

    MemberRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberRole record, @Param("example") MemberRoleExample example);

    int updateByExample(@Param("record") MemberRole record, @Param("example") MemberRoleExample example);

    int updateByPrimaryKeySelective(MemberRole record);

    int updateByPrimaryKey(MemberRole record);
}