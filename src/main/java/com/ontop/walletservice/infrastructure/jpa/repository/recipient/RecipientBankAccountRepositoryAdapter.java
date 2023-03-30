package com.ontop.walletservice.infrastructure.jpa.repository.recipient;

import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.repository.BankAccountRepository;
import com.ontop.walletservice.infrastructure.jpa.entity.RecipientBankAccountEntity;
import com.ontop.walletservice.infrastructure.jpa.mapper.RecipientBankAccountRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class RecipientBankAccountRepositoryAdapter implements BankAccountRepository {

    private final RecipientBankAccountEntityRepository bankAccountRepository;

    private final RecipientBankAccountRepositoryMapper recipientBankAccountRepositoryMapper
            = RecipientBankAccountRepositoryMapper.INSTANCE;


    @Override
    public RecipientBankAccount save(RecipientBankAccount recipientBankAccount) {
        RecipientBankAccountEntity recipientBankAccountEntity = recipientBankAccountRepositoryMapper.toRecipientBankAccountEntity(recipientBankAccount);
        RecipientBankAccountEntity recipientBankAccountEntitySaved = bankAccountRepository.save(recipientBankAccountEntity);
        return recipientBankAccountRepositoryMapper.toRecipientBankAccount(recipientBankAccountEntitySaved);
    }

    @Override
    public Optional<RecipientBankAccount> findByUserId(Long userId) {
        return bankAccountRepository.findByUserId(userId)
                .map(recipientBankAccountRepositoryMapper::toRecipientBankAccount);
    }

}
