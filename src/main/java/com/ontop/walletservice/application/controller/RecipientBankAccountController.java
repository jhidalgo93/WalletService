package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.recipient.RecipientBankAccountRequest;
import com.ontop.walletservice.application.dto.recipient.RecipientBankAccountResponse;
import com.ontop.walletservice.application.mapper.RecipientBankAccountMapper;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.service.recipient.RecipientBankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user/{user_id}/recipient-bank-accounts")
public class RecipientBankAccountController {

    private final RecipientBankAccountService recipientBankAccountService;

    private final RecipientBankAccountMapper bankAccountRequestMapper = RecipientBankAccountMapper.INSTANCE;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipientBankAccountResponse createBankAccount(@PathVariable("user_id") long userId,
                                                          @RequestBody @Valid RecipientBankAccountRequest recipientBankAccountRequest) {
        RecipientBankAccount recipientBankAccount = bankAccountRequestMapper.toBankAccount(recipientBankAccountRequest);
        recipientBankAccount.setUserId(userId);

        return bankAccountRequestMapper.toBankAccountResponse(recipientBankAccountService.createBankAccount(recipientBankAccount));
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RecipientBankAccountResponse getBankAccount(@PathVariable("user_id") long userId) {
        RecipientBankAccount recipientBankAccount = recipientBankAccountService.getBankAccountByUserId(userId);
        return bankAccountRequestMapper.toBankAccountResponse(recipientBankAccount);
    }


}
