package com.turing.website.config;

import com.turing.website.bean.Member;
import com.turing.website.bean.Role;
import com.turing.website.service.MemberService;
import com.turing.website.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Meng
 * @date 2019/9/2
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private MemberService memberService;
    @Autowired
    private RoleService roleService;

    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String studentNo=(String)principalCollection.getPrimaryPrincipal();
        Member member = memberService.getMemberByStudentNo(studentNo);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<>();
        List<Role> roles1=roleService.getRoleByStudentNo(studentNo);
        for (Role role:roles1){
            roles.add(role.getRoleName());
        }
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String studentNo = authenticationToken.getPrincipal().toString();
        Member member = memberService.getMemberByStudentNo(studentNo);
        if (member == null) {
            return null;
        } else {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(member.getStudentNo(),member.getPassword(),getName());
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("member",member);
            return authenticationInfo;
        }
    }
}
