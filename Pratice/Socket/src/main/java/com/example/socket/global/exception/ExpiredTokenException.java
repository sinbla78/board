package com.example.socket.global.exception;


import com.example.socket.global.error.exception.BusinessException;
import com.example.socket.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new ExpiredTokenException();
    public ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}