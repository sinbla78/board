package com.example.socket.domain.user.service;


import com.example.socket.domain.auth.RefreshTokenRepository;
import com.example.socket.domain.user.controller.dto.request.ChangePasswordRequest;
import com.example.socket.domain.user.controller.dto.request.LoginRequest;
import com.example.socket.domain.user.controller.dto.request.SignupRequest;
import com.example.socket.domain.user.controller.dto.response.MyPageResponse;
import com.example.socket.domain.user.domain.User;
import com.example.socket.domain.user.domain.UserRepository;
import com.example.socket.domain.user.service.exception.PasswordMismatchException;
import com.example.socket.domain.user.service.exception.UserAlreadyExistException;
import com.example.socket.domain.user.service.exception.UserNotFoundException;
import com.example.socket.domain.user.service.facade.UserFacade;
import com.example.socket.global.security.TokenResponse;
import com.example.socket.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;


    @Transactional
    public void signUp(SignupRequest signupRequest) {

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .email(signupRequest.getEmail())
                        .userName(signupRequest.getUserName())
                        .password(signupRequest.getPassword())
                        .number(signupRequest.getNumber())
                        .build()
        );
    }

    @Transactional
    public TokenResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!request.getPassword().equals(user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        TokenResponse token = jwtTokenProvider.createToken(user.getEmail());
        return token;

    }

    @Transactional
    public TokenResponse reissue(String refreshToken) {
        return jwtTokenProvider.reissue(refreshToken);
    }


    public MyPageResponse myPage() {
        User currentUser = userFacade.getCurrentUser();

        return new MyPageResponse(currentUser);
    }

    @Transactional
    public void passwordChange(ChangePasswordRequest request) {

        User user = userFacade.getCurrentUser();

        if (user.getPassword() == null) {
            throw UserNotFoundException .EXCEPTION;
        }

        if (!request.getOldPassword().equals(user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        user.changePassword(request.getNewPassword());
        userRepository.save(user);
    }

    @Transactional
    public void withdrawal(Long userId) {
        User user = userFacade.getCurrentUser();

        userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        userRepository.deleteById(userId);
    }

}
