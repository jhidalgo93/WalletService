package com.ontop.walletservice.infrastructure.jpa.repository.wallet.transaction;

import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import com.ontop.walletservice.domain.repository.WalletTransactionRepository;
import com.ontop.walletservice.infrastructure.jpa.entity.WalletTransactionEntity;
import com.ontop.walletservice.infrastructure.jpa.mapper.WalletTransactionRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class WalletTransactionRepositoryAdapter implements WalletTransactionRepository {

    private final WalletTransactionEntityRepository walletTransactionEntityRepository;

    private final WalletTransactionRepositoryMapper walletTransactionRepositoryMapper
            = WalletTransactionRepositoryMapper.INSTANCE;


    @Override
    @Transactional
    public WalletTransaction save(WalletTransaction walletTransaction) {

        WalletTransactionEntity walletTransactionEntity = walletTransactionRepositoryMapper
                .toWalletTransactionEntity(walletTransaction);

        return walletTransactionRepositoryMapper
                .toWalletTransaction(walletTransactionEntityRepository.save(walletTransactionEntity));
    }
}
