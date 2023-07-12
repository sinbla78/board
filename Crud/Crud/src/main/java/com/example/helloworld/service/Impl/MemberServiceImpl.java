package com.example.helloworld.service.Impl;


import com.example.helloworld.dto.MemberFormDTO;
import com.example.helloworld.repository.MemberRepository;
import com.example.helloworld.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service            // 내가 서비스다
@RequiredArgsConstructor    // 밑에 MemberRepository의 생성자를 쓰지 않기 위해서
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberFormDTO memberFormDTO) {
        Member member = member.f
                .email(memberFormDTO.getEmail())
                .username(memberFormDTO.getUsername())
                .password(memberFormDTO.getPassword())
                .build();

        return MemberRepository.save(member).getId();
    }
}