package com.ontop.walletservice.domain.exception;

public class InvalidBankAccountException extends RuntimeException {

    public InvalidBankAccountException(String message){
        super(message);
    }
}
