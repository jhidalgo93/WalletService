package com.ontop.walletservice.infrastructure.repository.wallet.mapper;

import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;
import com.ontop.walletservice.infrastructure.repository.wallet.entity.WalletBankAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletBankAccountRepositoryMapper {

    WalletBankAccountRepositoryMapper INSTANCE = Mappers.getMapper(WalletBankAccountRepositoryMapper.class);

    WalletBankAccount toWalletBankAccount(WalletBankAccountEntity walletBankAccountEntity);

}
