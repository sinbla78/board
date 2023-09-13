package com.example.cmd.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode { //에러 코드는 Enum으로 관리

    //jwt
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    //user
    USER_NOT_FOUND(404,"User not found"),//클라이언트가 요청한 문서를 찾지못한 경우에 발생함
    USER_ALREADY_EXISTS(409,"User already exists, 이미 유저가 존재합니다,"),
    PASSWORD_MISMATCH(404,"Password mismatch"),

    // board
    BOARD_NOT_FOUND(404, "Board not found"),
    BOARD_WRITER_MISMATCH(403, "Board writer mismatch"),

    //general
    BAD_REQUEST(400, "Bad request"),
    //잘못된 요청으로써 문법상 오류가 있어서 서버가 요청사항을 이해하지 못하는 경우
    INTERNAL_SERVER_ERROR(500, "Internal server error");
    //서버 내부 오류는 웹 서버가 요청사항을 수행할 수 없을 경우에 발생함

    private final int statusCode;
    private final String message;
}
