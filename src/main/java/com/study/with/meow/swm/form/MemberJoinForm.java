package com.study.with.meow.swm.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberJoinForm {
    
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자 id는 필수항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String repassword;

    @NotEmpty(message = "닉네임은 필수항목입니다.")
    private String nickname;

}
