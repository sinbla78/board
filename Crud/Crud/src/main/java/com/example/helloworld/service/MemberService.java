package com.example.helloworld.service;


import com.example.helloworld.dto.MemberFormDTO;

public interface MemberService {

    Long join(MemberFormDTO memberFormDTO);
}
