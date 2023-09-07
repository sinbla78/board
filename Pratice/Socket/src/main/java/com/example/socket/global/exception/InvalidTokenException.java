package com.example.socket.global.exception;


import com.example.socket.global.error.exception.BusinessException;
import com.example.socket.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidTokenException();
    //
    public InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);

    }
}
