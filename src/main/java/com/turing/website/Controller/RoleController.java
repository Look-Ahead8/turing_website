package com.turing.website.Controller;

import com.turing.website.message.Message;
import com.turing.website.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Meng
 * @date 2019/9/8
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/role/{memberId}")
    public Message getRoleById(@PathVariable("memberId") Integer memberId){
        return Message.success().add("role",roleService.getRolesBymId(memberId));
    }
}
