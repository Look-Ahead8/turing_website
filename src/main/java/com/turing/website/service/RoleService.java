package com.turing.website.service;

import com.turing.website.bean.Role;

import java.util.List;

/**
 * @author Meng
 * @date 2019/9/3
 */
public interface RoleService {
    List<Role> getRoleByStudentNo(String studentNo);
    List<Role> getRolesBymId(Integer memberId);
}
