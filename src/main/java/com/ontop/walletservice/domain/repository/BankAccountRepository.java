package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;

import java.util.Optional;

public interface BankAccountRepository {

    RecipientBankAccount save(RecipientBankAccount recipientBankAccount);

    Optional<RecipientBankAccount> findByUserId(Long userId);

}
