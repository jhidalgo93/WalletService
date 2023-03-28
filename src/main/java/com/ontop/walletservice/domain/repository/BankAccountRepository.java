package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.BankAccount;

public interface RecipientBankAccountRepository {

    BankAccount save(BankAccount bankAccount);

}
