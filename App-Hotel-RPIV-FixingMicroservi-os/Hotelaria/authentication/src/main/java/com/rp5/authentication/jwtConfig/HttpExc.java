package com.rp5.authentication.jwtConfig;

import org.springframework.http.HttpStatus;

public class HttpExc extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String mensagem;
    private final HttpStatus httpStatus;

    public HttpExc(String mensagem, HttpStatus httpStatus) {
        this.mensagem = mensagem;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
