package com.example.springboot.repository.server.exception;

import com.example.springboot.repository.server.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends RuntimeException{
    private ServerErrorResponseDto serverErrorResponseDto;
    private HttpStatus httpStatus;

    public InternalServerErrorException( ServerErrorResponseDto serverErrorResponseDto, HttpStatus httpStatus ) {
        this.serverErrorResponseDto = serverErrorResponseDto;
        this.httpStatus = httpStatus;
    }
}
