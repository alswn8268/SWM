package com.study.with.meow.swm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.study.with.meow.swm.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyPageController {
    
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/myPage")
    public String myPage() {
        log.info("MyPageController myPage()");

        return "myPage/myPage";
    }


}
