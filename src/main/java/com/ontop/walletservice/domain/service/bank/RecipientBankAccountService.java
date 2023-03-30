package com.ontop.walletservice.domain.service.bank;

import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;

public interface RecipientBankAccountService {

    RecipientBankAccount createBankAccount(RecipientBankAccount recipientBankAccount);

    RecipientBankAccount getBankAccountByUserId(Long userId);

}
