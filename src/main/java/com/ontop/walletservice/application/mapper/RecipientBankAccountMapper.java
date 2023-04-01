package com.ontop.walletservice.application.mapper;

import com.ontop.walletservice.application.dto.recipient.RecipientBankAccountRequest;
import com.ontop.walletservice.application.dto.recipient.RecipientBankAccountResponse;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientBankAccountMapper {

    RecipientBankAccountMapper INSTANCE = Mappers.getMapper(RecipientBankAccountMapper.class);


    RecipientBankAccountResponse toBankAccountResponse(RecipientBankAccount recipientBankAccount);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "id", ignore = true)
    RecipientBankAccount toBankAccount(RecipientBankAccountRequest recipientBankAccountRequest);

}
