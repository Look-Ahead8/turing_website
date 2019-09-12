package com.turing.website.service;

import com.turing.website.bean.Member;

import java.util.List;

/**
 * @author Meng
 * @date 2019/9/2
 */
public interface MemberService {
    Member getMemberByStudentNo(String studentNo);

    int valid(String studentNo, String password);

    void updateMember(Member member);

    List<Member> selectAllMember();
}
