package com.fastcampus.fastcampusprojectboard.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article; // 게시긓 {ID}
    private String content; // 해시태그

    private LocalDateTime createdAt; // 생성 일시
    private String createdBy; // 생성자
    private LocalDateTime modifiedAt; // 수정 일시
    private String modifiedBy; // 수정자
}
