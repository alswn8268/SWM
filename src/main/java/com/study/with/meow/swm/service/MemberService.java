package com.study.with.meow.swm.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.with.meow.swm.dto.MemberDto;
import com.study.with.meow.swm.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDto create(String username, String password, String nickname) {
        MemberDto member = new MemberDto();
        member.setUsername(username);
        member.setNickname(nickname);
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member.toEntity());
        return member;
    }

}
