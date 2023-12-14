package com.example.cmd.domain.user.controller;

import com.example.cmd.domain.user.controller.dto.request.LoginRequest;
import com.example.cmd.domain.user.controller.dto.request.SignupRequest;
import com.example.cmd.domain.user.controller.dto.request.ChangePasswordRequest;
import com.example.cmd.domain.user.controller.dto.response.MyPageResponse;
import com.example.cmd.domain.user.service.UserService;
import com.example.cmd.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("signup")
    public void signup(@RequestBody @Valid SignupRequest signupRequest) {
        userService.signUp(signupRequest);
    }

    @PostMapping("login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "AUTHORIZATION_HEADER") String refreshToken) {
        return userService.reissue(refreshToken);
    }

    @GetMapping("/myPage")
    public MyPageResponse myPage() {
        return userService.myPage();
    }

    @PatchMapping("/chagePassword")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        userService.passwordChange(request);

    }

    @DeleteMapping("/withdrawal/{userId}")
    public void withdrawal(@PathVariable Long userId) {
        userService.withdrawal(userId);
    }
}
