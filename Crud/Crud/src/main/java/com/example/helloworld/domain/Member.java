package com.example.helloworld.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity(name = "MEMBER")
public class Member {
    // id 컬럼을 MEMBER 테이블의 기본키로 설정
    @Id
    private String id;
    private String password;
    private MemberAuthority authority;

    @Builder
    public Member(String id, String password, MemberAuthority authority) {
        this.id = id;
        this.password = password;
        this.authority = authority;
    }
}