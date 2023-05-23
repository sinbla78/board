package com.example.mvc.domain.board.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardResponse {
    private final long id;

    private final String title;

    private final String contents;

    private final LocalDateTime createAt;
}
