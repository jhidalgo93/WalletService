package com.ontop.walletservice.infrastructure.jpa.repository.adapter;

import com.ontop.walletservice.domain.model.bank.RecipientBankAccount;
import com.ontop.walletservice.domain.repository.BankAccountRepository;
import com.ontop.walletservice.infrastructure.jpa.entity.BankAccountEntity;
import com.ontop.walletservice.infrastructure.jpa.mapper.BankAccountRepositoryMapper;
import com.ontop.walletservice.infrastructure.jpa.repository.BankAccountEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BankAccountRepositoryAdapter implements BankAccountRepository {

    private final BankAccountEntityRepository bankAccountRepository;

    private final BankAccountRepositoryMapper bankAccountRepositoryMapper
            = BankAccountRepositoryMapper.INSTANCE;


    public BankAccountRepositoryAdapter(BankAccountEntityRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

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
