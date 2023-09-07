package com.example.socket.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
public class ChangePasswordRequest {

    private String oldPassword;

    @Pattern(regexp = "^(?=.*[!@#$%^&*?])(?=.{8,30}$).*",
            message = "비밀번호는 최대 20글자이고, 특수문자 1개 이상이 포함되어야 합니다.")
    private String newPassword;
}
