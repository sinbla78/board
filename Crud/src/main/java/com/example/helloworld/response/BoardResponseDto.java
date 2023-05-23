package com.example.helloworld.response;

import com.example.helloworld.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
