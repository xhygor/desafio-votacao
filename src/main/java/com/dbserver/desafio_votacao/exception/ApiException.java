package com.dbserver.desafio_votacao.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final Exception exception;
    private final String mensagem;

    public ApiException(HttpStatus httpStatus, String mensagem, Exception exception) {
        this.httpStatus = httpStatus;
        this.mensagem = mensagem;
        this.exception = exception;
    }
}
