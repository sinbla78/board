package com.example.helloworld.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {
    //필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Member.class)
    @JoinColumn(name = "member_id", updatable = false)
    public Member member;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    //빌더
    @Builder
    public Board(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }
}