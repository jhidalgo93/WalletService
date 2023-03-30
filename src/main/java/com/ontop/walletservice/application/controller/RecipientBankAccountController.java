package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.bank.BankAccountRequest;
import com.ontop.walletservice.application.dto.bank.BankAccountResponse;
import com.ontop.walletservice.application.mapper.BankAccountMapper;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.service.bank.RecipientBankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user/{user_id}/recipient-bank-account")
public class RecipientBankAccountController {

    private final RecipientBankAccountService recipientBankAccountService;

    private final BankAccountMapper bankAccountRequestMapper = BankAccountMapper.INSTANCE;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccountResponse createBankAccount(@PathVariable("user_id") long userId,
                                                 @RequestBody @Valid BankAccountRequest bankAccountRequest) {
        RecipientBankAccount recipientBankAccount = bankAccountRequestMapper.toBankAccount(bankAccountRequest);
        recipientBankAccount.setUserId(userId);

        return bankAccountRequestMapper.toBankAccountResponse(recipientBankAccountService.createBankAccount(recipientBankAccount));
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public BankAccountResponse getBankAccount(@PathVariable("user_id") long userId) {
        RecipientBankAccount recipientBankAccount = recipientBankAccountService.getBankAccountByUserId(userId);
        return bankAccountRequestMapper.toBankAccountResponse(recipientBankAccount);
    }


}
