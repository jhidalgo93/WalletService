package com.ontop.walletservice.application.mapper;

import com.ontop.walletservice.application.dto.BankAccountRequest;
import com.ontop.walletservice.domain.model.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountRequestMapper {

    BankAccountRequestMapper INSTANCE = Mappers.getMapper(BankAccountRequestMapper.class);


    BankAccountRequest toBankAccountRequest(BankAccount bankAccount);

    @Mapping(target = "userId", ignore = true)
    BankAccount toBankAccount(BankAccountRequest bankAccountRequest);

}
