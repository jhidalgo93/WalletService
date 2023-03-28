package com.ontop.walletservice.application.mapper;

import com.ontop.walletservice.application.dto.bank.BankAccountRequest;
import com.ontop.walletservice.application.dto.bank.BankAccountResponse;
import com.ontop.walletservice.domain.model.bank.RecipientBankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountMapper {

    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);


    BankAccountResponse toBankAccountResponse(RecipientBankAccount recipientBankAccount);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "id", ignore = true)
    RecipientBankAccount toBankAccount(BankAccountRequest bankAccountRequest);

}
