package com.example.socket.domain.user.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @NotNull(message = "이메일을 입력하세요")
    private String email;

    @NotNull(message = "비밀번호를 입력하세요")
    private String password;
}
