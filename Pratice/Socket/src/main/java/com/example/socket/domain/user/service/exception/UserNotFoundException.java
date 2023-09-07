package com.example.socket.domain.user.service.exception;


import com.example.socket.global.error.exception.BusinessException;
import com.example.socket.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();
    public UserNotFoundException(){
        super (ErrorCode.USER_NOT_FOUND);
    }
}