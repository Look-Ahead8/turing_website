package com.turing.website.service.impl;

import com.turing.website.bean.Member;
import com.turing.website.bean.MemberExample;
import com.turing.website.dao.MemberMapper;
import com.turing.website.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Meng
 * @date 2019/9/2
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    @Cacheable("member")
    public Member getMemberByStudentNo(String studentNo) {
        MemberExample memberExample=new MemberExample();
        MemberExample.Criteria criteria=memberExample.createCriteria();
        criteria.andStudentNoEqualTo(studentNo);
        List<Member> member=memberMapper.selectByExample(memberExample);
        return  member.isEmpty()?null:member.get(0);
    }

    /**
     * 登录的学号密码校验
     * @param studentNo 学号
     * @param password  密码
     * @return 0均合法1均不合法2密码不合法3账号不合法
     */
    @Override
    public int valid(String studentNo, String password) {
        boolean isValidStudentNo=studentNo.length()==12;
        boolean isValidPassword=password.length()<=16&&password.length()>=6;
        if(isValidPassword&&isValidStudentNo){
            return 0;
        }
       if (isValidPassword==false&&isValidStudentNo==false){
           return 1;
       }
       else{
           int result=isValidStudentNo?2:3;
           return result;
       }
    }

    /**
     * 修改成员信息
     * @param member 新的成员信息
     */
    public void updateMember(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    /**
     *返回全部成员信息
     * @return 成员集合
     */
    @Override
    public List<Member> selectAllMember() {
        MemberExample memberExample=new MemberExample();
        return memberMapper.selectByExample(memberExample);
    }

    ;
}
