package com.ontop.walletservice.infrastructure.jpa.repository.wallet;

import com.ontop.walletservice.infrastructure.jpa.entity.WalletTransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletTransactionEntityRepository extends CrudRepository<WalletTransactionEntity, String> {
}
