package com.ontop.walletservice.application.config;

import com.ontop.walletservice.domain.exception.GeneralErrorWalletException;
import com.ontop.walletservice.domain.exception.InvalidBankAccountException;
import com.ontop.walletservice.domain.exception.AccountNotFoundException;
import com.ontop.walletservice.domain.exception.InvalidPaymentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(AccountNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler({InvalidBankAccountException.class, InvalidPaymentException.class})
    public ResponseEntity<String> handleBadRequestException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(GeneralErrorWalletException.class)
    public ResponseEntity<String> handleInternalServerException(GeneralErrorWalletException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}
