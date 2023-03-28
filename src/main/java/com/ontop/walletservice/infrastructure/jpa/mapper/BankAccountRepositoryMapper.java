package com.ontop.walletservice.infrastructure.jpa.mapper;

import com.ontop.walletservice.domain.model.bank.RecipientBankAccount;
import com.ontop.walletservice.infrastructure.jpa.entity.BankAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountRepositoryMapper {

    BankAccountRepositoryMapper INSTANCE = Mappers.getMapper(BankAccountRepositoryMapper.class);

    BankAccountEntity toRecipientBankAccountEntity(RecipientBankAccount recipientBankAccount);

    RecipientBankAccount toRecipientBankAccount(BankAccountEntity bankAccountEntity);


}
