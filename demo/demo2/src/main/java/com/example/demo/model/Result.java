package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.ErrorResponse;

@Getter
@Setter
public class Result {
    private ErrorResponse error;
    private Object payload;
}
