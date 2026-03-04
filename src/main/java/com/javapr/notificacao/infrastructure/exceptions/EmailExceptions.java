package com.javapr.notificacao.infrastructure.exceptions;

public class EmailExceptions extends RuntimeException {

    public EmailExceptions(String message){
        super(message);
    }

    public EmailExceptions(String message, Throwable throwable){
        super(message, throwable);
    }
}
