package com.ontop.walletservice.domain.exception;

public class InvalidPaymentException extends RuntimeException{

    public InvalidPaymentException(String message) {
        super(message);
    }
}
