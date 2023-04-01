package com.ontop.walletservice.domain.service.recipient;

import com.ontop.walletservice.domain.exception.AccountNotFoundException;
import com.ontop.walletservice.domain.exception.InvalidBankAccountException;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.repository.RecipientBankAccountRepository;


public class DomianRecipientBankAccountService implements RecipientBankAccountService {


    private final RecipientBankAccountRepository recipientBankAccountRepository;


    public DomianRecipientBankAccountService(RecipientBankAccountRepository recipientBankAccountRepository) {
        this.recipientBankAccountRepository = recipientBankAccountRepository;
    }

    @Override
    public RecipientBankAccount createBankAccount(RecipientBankAccount recipientBankAccount) {
        validBankAccount(recipientBankAccount);
        return recipientBankAccountRepository.save(recipientBankAccount);
    }

    @Override
    public RecipientBankAccount getBankAccountByUserId(Long userId) {
        return recipientBankAccountRepository.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFoundException("The user does not have a registered bank account"));
    }

    private void validBankAccount(RecipientBankAccount recipientBankAccount) {

        if(recipientBankAccount == null)
            throw new InvalidBankAccountException("To create an bank account it's mandatory provide bank account data");

        recipientBankAccountRepository.findByUserId(recipientBankAccount.getUserId()).ifPresent(it -> {
                    throw new InvalidBankAccountException(String.format("The user with id %s already has a registered bank account.", recipientBankAccount.getUserId()));
                });
    }

}
