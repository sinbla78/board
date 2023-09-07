package com.example.socket.domain.user.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    @NotNull(message = "이름을 입력하세요")
    private String userName;

    @NotNull(message = "이메일을 입력하세요")
    private String email;

    @Pattern(regexp = "^(?=.*[!@#$%^&*?])(?=.{8,30}$).*",
            message = "비밀번호는 최대 20글자이고, 특수문자 1개 이상이 포함되어야 합니다.")
    private String password;

    @NotNull(message = "전화번호를 입력하세요")
    private String number;
}
