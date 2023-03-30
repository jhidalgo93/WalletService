package com.ontop.walletservice.infrastructure.jpa.mapper;

import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import com.ontop.walletservice.infrastructure.jpa.entity.WalletTransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletTransactionRepositoryMapper {

    WalletTransactionRepositoryMapper INSTANCE = Mappers.getMapper(WalletTransactionRepositoryMapper.class);

    WalletTransactionEntity toWalletTransactionEntity(WalletTransaction walletTransaction);

    WalletTransaction toWalletTransaction(WalletTransactionEntity walletTransactionEntity);

}
