package com.turing.website.Controller;

import com.turing.website.bean.Member;
import com.turing.website.message.Message;
import com.turing.website.service.MemberService;
import com.turing.website.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Meng
 * @date 2019/9/2
 */
@RestController
public class LoginController {
    @Autowired
    private MemberService memberService;
    @PostMapping("/login")
    public Message login(@RequestParam("studentNo") String studentNo,@RequestParam("password")String password){
        Map<String,Object> map=new HashMap<>();
        if(memberService.valid(studentNo,password)!=0){
            int result=memberService.valid(studentNo,password);
            if(result==1){
                map.put("studentNo","请填写正确的学号");
                map.put("password","请填写6-16位密码");
            }
            else if(result==2){
                map.put("password","请填写6-16位密码");
            }
            else{
                map.put("studentNo","请填写正确的学号");
            }
            return Message.fail().add("error",map);
        }
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(studentNo, MD5Util.md5(password));
        try{
            subject.login(token);
            Member member  = (Member) SecurityUtils.getSubject().getSession().getAttribute("member");
            return Message.success().add("member",member);
        }catch (UnknownAccountException e){
            map.put("message","登录失败，请检查用户名和账户");
            return Message.fail().add("error",map);
        }catch (IncorrectCredentialsException e){
            map.put("message","登录失败，请检查用户名和账户");
            return Message.fail().add("error",map);
        }
    }

    @GetMapping("/login")
    public Message getLogin(){
        Member member  = (Member) SecurityUtils.getSubject().getSession().getAttribute("member");
        return Message.success().add("member",member);
    }
}
