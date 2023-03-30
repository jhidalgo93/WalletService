package com.ontop.walletservice.infrastructure.jpa.mapper;

import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.infrastructure.jpa.entity.RecipientBankAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientBankAccountRepositoryMapper {

    RecipientBankAccountRepositoryMapper INSTANCE = Mappers.getMapper(RecipientBankAccountRepositoryMapper.class);

    RecipientBankAccountEntity toRecipientBankAccountEntity(RecipientBankAccount recipientBankAccount);

    RecipientBankAccount toRecipientBankAccount(RecipientBankAccountEntity recipientBankAccountEntity);

}
