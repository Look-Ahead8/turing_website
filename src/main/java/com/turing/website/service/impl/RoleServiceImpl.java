package com.turing.website.service.impl;

import com.turing.website.bean.Role;
import com.turing.website.dao.RoleMapper;
import com.turing.website.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/9/3
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    @Cacheable("{role}")
    public List<Role> getRoleByStudentNo(String studentNo) {
        return roleMapper.selectByStudentNo(studentNo);
    }

    @Override
    public List<Role> getRolesBymId(Integer memberId) {
        return roleMapper.selectByMemberId(memberId);
    }
}
