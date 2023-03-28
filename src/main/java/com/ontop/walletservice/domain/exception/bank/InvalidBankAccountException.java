package com.ontop.walletservice.domain.exception.bank;

public class InvalidBankAccountException extends RuntimeException {

    public InvalidBankAccountException(String message){
        super(message);
    }
}
