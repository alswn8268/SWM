package com.study.with.meow.swm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.dao.DataIntegrityViolationException;

import com.study.with.meow.swm.dto.MemberDto;
import com.study.with.meow.swm.form.MemberJoinForm;
import com.study.with.meow.swm.repository.MemberRepository;
import com.study.with.meow.swm.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
    
    @Autowired
    private MemberRepository memberRepository;
    private MemberService memberService;
    
    @GetMapping("/")
    public String main() {
        log.info("MemberController의 main()");
        return "main";
    }
    
    @GetMapping("/main")
    public String main2() {
        log.info("MemberController의 main()");
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        log.info("MemberController의 login() - GET");

        return "login/login";
    }

    @GetMapping("/joinMember")
    public String joinMember(MemberJoinForm memberJoinForm) {
        log.info("MemberController의 joinMember() - GET");
        
        return "login/joinMember";
    }

    @PostMapping("/joinMember")
    public String joinMember(MemberDto memberDto, @Valid MemberJoinForm memberJoinForm, BindingResult bindingResult, HttpServletRequest request) {
        log.info("MemberController의 joinOK() - POST");

        if (bindingResult.hasErrors()) {
            return "redirect:joinMember";
        }
        
        if (!memberJoinForm.getPassword().trim().equals(memberJoinForm.getRepassword().trim())) {
            bindingResult.rejectValue("repassword", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
            return "redirect:joinMember";
        }
        
        try {
            memberService.create(memberJoinForm.getUsername(), memberJoinForm.getPassword(), memberJoinForm.getNickname());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            System.out.println("4");
            return "redirect:joinMember";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            System.out.println("5");
            return "redirect:joinMember";
        }

        return "main";
    }

}
