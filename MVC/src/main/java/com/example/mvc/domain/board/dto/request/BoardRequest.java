package com.example.mvc.domain.board.dto.request;

import lombok.Data;

@Data
public class BoardRequest {
    private String title;

    private String contents;
}
