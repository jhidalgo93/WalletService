package com.ontop.walletservice.infrastructure.repository.wallet;

import com.ontop.walletservice.infrastructure.repository.wallet.entity.WalletBankAccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletBankAccountEntityRepository extends CrudRepository<WalletBankAccountEntity, Long> {
}
