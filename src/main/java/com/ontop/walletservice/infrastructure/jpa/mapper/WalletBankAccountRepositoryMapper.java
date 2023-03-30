package com.ontop.walletservice.infrastructure.jpa.mapper;

import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import com.ontop.walletservice.infrastructure.jpa.entity.WalletBankAccountEntity;
import com.ontop.walletservice.infrastructure.jpa.entity.WalletTransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletBankAccountRepositoryMapper {

    WalletBankAccountRepositoryMapper INSTANCE = Mappers.getMapper(WalletBankAccountRepositoryMapper.class);

    WalletBankAccount toWalletBankAccount(WalletBankAccountEntity walletBankAccountEntity);

}
