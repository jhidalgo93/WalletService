package com.ontop.walletservice.infrastructure.jpa.repository.bank;

import com.ontop.walletservice.domain.model.bank.RecipientBankAccount;
import com.ontop.walletservice.domain.repository.BankAccountRepository;
import com.ontop.walletservice.infrastructure.jpa.entity.BankAccountEntity;
import com.ontop.walletservice.infrastructure.jpa.mapper.BankAccountRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class BankAccountRepositoryAdapter implements BankAccountRepository {

    private final BankAccountEntityRepository bankAccountRepository;

    private final BankAccountRepositoryMapper bankAccountRepositoryMapper
            = BankAccountRepositoryMapper.INSTANCE;


    @Override
    public RecipientBankAccount save(RecipientBankAccount recipientBankAccount) {
        BankAccountEntity bankAccountEntity = bankAccountRepositoryMapper.toRecipientBankAccountEntity(recipientBankAccount);
        BankAccountEntity bankAccountEntitySaved = bankAccountRepository.save(bankAccountEntity);
        return bankAccountRepositoryMapper.toRecipientBankAccount(bankAccountEntitySaved);
    }

    @Override
    public Optional<RecipientBankAccount> findByUserId(Long userId) {
        return bankAccountRepository.findByUserId(userId)
                .map(bankAccountRepositoryMapper::toRecipientBankAccount);
    }

}
