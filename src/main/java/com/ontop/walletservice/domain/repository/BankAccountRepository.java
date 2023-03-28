package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.bank.RecipientBankAccount;

import java.util.Optional;

public interface BankAccountRepository {

    RecipientBankAccount save(RecipientBankAccount recipientBankAccount);

    Optional<RecipientBankAccount> findByUserId(Long userId);

}
