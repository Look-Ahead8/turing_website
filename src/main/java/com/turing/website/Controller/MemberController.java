package com.turing.website.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.website.bean.Member;
import com.turing.website.message.Message;
import com.turing.website.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/9/6
 */
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PutMapping("/member")
    public Message updateMember(@Valid Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> errors=bindingResult.getFieldErrors();
            Map<String,String> map=new HashMap<>();
            for (FieldError error:errors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return Message.fail().add("errors",map);
        }
        memberService.updateMember(member);
        SecurityUtils.getSubject().getSession().setAttribute("member",member);
        return Message.success();
    }
    
    @GetMapping("/member")
    public Message selectAllMember(){
        PageHelper.startPage(10,5);
        List<Member> members=memberService.selectAllMember();
        PageInfo<Member> pageInfo=new PageInfo<>(members);
        return Message.success().add("members",pageInfo);
    }
}
