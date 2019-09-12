package com.turing.website.Controller;

import com.turing.website.message.Message;
import com.turing.website.service.MemberService;
import com.turing.website.util.FASTDFSUtil;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Meng
 * @date 2019/9/2
 */
@RestController
public class Test {
    @Autowired
    private MemberService memberService;
    @GetMapping("/test")
    public Message test(){
        System.out.println(memberService.getMemberByStudentNo("201711701120"));
        return Message.success();
    }

    @PostMapping("/test")
    public Message a(@RequestParam("file") MultipartFile files) throws IOException, MyException {
        String id=FASTDFSUtil.uploadFile("application.properties",files.getBytes(),files.getOriginalFilename());
        return Message.success().add("file",id);
    }
}
