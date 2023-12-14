package com.example.cmd.global.security.auth;


import com.example.cmd.domain.user.domain.User;
import com.example.cmd.domain.user.domain.UserRepository;
import com.example.cmd.domain.user.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {

        User user = userRepository.findByEmail(email)//그냥 유저 없으면 오류 발생
                .orElseThrow(UserNotFoundException::new);

        return new AuthDetails(user.getEmail());//아니면

     }
}
