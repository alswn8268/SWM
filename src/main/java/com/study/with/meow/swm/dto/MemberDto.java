package com.study.with.meow.swm.dto;

import com.study.with.meow.swm.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDto {
    
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String introduce = "";
    private String todo = "";

    //	DTO를 Entity로 변환하는 메소드
    public Member toEntity() {
        return new Member(null, username, password, nickname, introduce, todo);
    }

}
