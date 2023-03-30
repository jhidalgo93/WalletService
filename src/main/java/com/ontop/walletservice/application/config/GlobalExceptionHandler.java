package com.ontop.walletservice.application.config;

import com.ontop.walletservice.domain.exception.bank.InvalidBankAccountException;
import com.ontop.walletservice.domain.exception.bank.AccountNotFoundException;
import com.ontop.walletservice.domain.exception.payment.InvalidPaymentException;
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
}
