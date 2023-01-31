package com.study.with.meow.swm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.with.meow.swm.dto.MemberDto;
import com.study.with.meow.swm.entity.Member;
import com.study.with.meow.swm.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
    
    @Autowired
    private MemberRepository memberRepository;
    
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
        log.info("MemberController의 login()");

        return "login/login";
    }

    @PostMapping("/loginOK")
    public String loginOK(MemberDto memberDto, HttpServletRequest request, Model model) {
        log.info("MemberController의 loginOK()");
        
        // 입력한 아이디와 일치하는 정보를 db에서 얻어온다.
        Member memberEntity = memberRepository.findById(memberDto.getId()).orElse(null);

        // 입력한 비밀번호와 db에서 얻어온 비밀번호가 일치할 경우 로그인 정보를 세션에 저장한다.
        if (memberDto.getPassword().trim().equals(memberEntity.getPassword())) {
            
            HttpSession session = request.getSession();
			session.setAttribute("id", memberEntity.getId());
			session.setAttribute("nickname", memberEntity.getNickname());
			session.setAttribute("password", memberEntity.getPassword());            

        } else {
            
        }

        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        // 세션에서 로그인 정보를 삭제한다.
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("nickname");
		session.removeAttribute("password");

        return "main";
    }

    @PostMapping("/joinOK")
    public String joinOK(MemberDto memberDto) {
        log.info("MemberController의 joinOK()");
        
        // Dto를 entity 객체로 변환한다.
        Member member = memberDto.toEntity();
        // 변환된 entity 객체를 db에 저장한다.
        memberRepository.save(member);

        return "main";
    }

    @GetMapping("/joinMember")
    public String joinMember() {
        log.info("MemberController의 joinMember()");
        
        return "login/joinMember";
    }
    
    @ResponseBody
    @PostMapping("/idExists")
    public String idExists(MemberDto memberDto) {
        log.info("MemberController의 idExists()");

        // 입력한 아이디와 일치하는 정보를 db에서 얻어온다.
        Member memberEntity = memberRepository.findById(memberDto.getId()).orElse(null);
        if (memberEntity != null) {
            // memberEntity가 null이 아니므로 중복된 id가 있다는 뜻
            return "1";
        } else {
            // memberEntity가 null이므로 중복된 id가 없다는 뜻
            return "2";
        }

    }
    
    @ResponseBody
    @PostMapping("/nicknameExists")
    public int nicknameExists(MemberDto memberDto) {
        log.info("MemberController의 nicknameExists()");

        // 입력한 닉네임과 일치하는 정보를 db에서 얻어온다.
        Member memberEntity = memberRepository.findByNickname(memberDto.getNickname()).orElse(null);
        if (memberEntity != null) {
            // memberEntity가 null이 아니므로 중복된 닉네임이 있다는 뜻
            return 1;
        } else {
            // memberEntity가 null이 아니므로 중복된 닉네임이 없다는 뜻
            return 2;
        }
    }

}
