package com.ontop.walletservice.infrastructure.jpa.bank.mapper;

import com.ontop.walletservice.domain.model.bank.BankAccount;
import com.ontop.walletservice.infrastructure.jpa.bank.entity.BankAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountRepositoryMapper {

    BankAccountRepositoryMapper INSTANCE = Mappers.getMapper(BankAccountRepositoryMapper.class);

    BankAccountEntity toRecipientBankAccountEntity(BankAccount bankAccount);

    BankAccount toRecipientBankAccount(BankAccountEntity bankAccountEntity);


}
