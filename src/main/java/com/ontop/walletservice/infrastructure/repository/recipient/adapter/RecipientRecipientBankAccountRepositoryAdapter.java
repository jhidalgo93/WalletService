package com.ontop.walletservice.infrastructure.repository.recipient.adapter;

import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.repository.RecipientBankAccountRepository;
import com.ontop.walletservice.infrastructure.repository.recipient.RecipientBankAccountEntityRepository;
import com.ontop.walletservice.infrastructure.repository.recipient.entity.RecipientBankAccountEntity;
import com.ontop.walletservice.infrastructure.repository.recipient.mapper.RecipientBankAccountRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class RecipientRecipientBankAccountRepositoryAdapter implements RecipientBankAccountRepository {

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
