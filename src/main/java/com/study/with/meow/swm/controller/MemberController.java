package com.study.with.meow.swm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.with.meow.swm.dto.MemberDto;
import com.study.with.meow.swm.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
    
    @Autowired
    private MemberRepository memberRepository;
    
    @GetMapping
    public String login() {
        log.info("MemberController의 login()");

        return "login/login";
    }

    @PostMapping
    public String loginOK(MemberDto memberDto) {
        log.info("MemberController의 loginOK()");

        


        return "main";
    }

}
