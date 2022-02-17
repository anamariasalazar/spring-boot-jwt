package com.example.springboot.repository.server.exception;

import com.example.springboot.repository.server.ErrorCodeEnum;
import com.example.springboot.repository.server.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException() {

        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);

    }
}