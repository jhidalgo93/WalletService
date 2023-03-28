package com.ontop.walletservice.infrastructure.jpa.bank.repository.adapter;

import com.ontop.walletservice.domain.model.bank.BankAccount;
import com.ontop.walletservice.domain.repository.BankAccountRepository;
import com.ontop.walletservice.infrastructure.jpa.bank.entity.BankAccountEntity;
import com.ontop.walletservice.infrastructure.jpa.bank.mapper.BankAccountRepositoryMapper;
import com.ontop.walletservice.infrastructure.jpa.bank.repository.BankAccountEntityRepository;
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
    public BankAccount save(BankAccount bankAccount) {
        BankAccountEntity bankAccountEntity = bankAccountRepositoryMapper.toRecipientBankAccountEntity(bankAccount);
        BankAccountEntity bankAccountEntitySaved = bankAccountRepository.save(bankAccountEntity);
        return bankAccountRepositoryMapper.toRecipientBankAccount(bankAccountEntitySaved);
    }

    @Override
    public Optional<BankAccount> findByUserId(Long userId) {
        return bankAccountRepository.findByUserId(userId)
                .map(bankAccountRepositoryMapper::toRecipientBankAccount);
    }

}
