package com.example.socket.domain.user.service.exception;


import com.example.socket.global.error.exception.BusinessException;
import com.example.socket.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException(){
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}