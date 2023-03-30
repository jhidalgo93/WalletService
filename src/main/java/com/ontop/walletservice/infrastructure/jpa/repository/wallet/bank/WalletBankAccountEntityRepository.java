package com.ontop.walletservice.infrastructure.jpa.repository.wallet.bank;

import com.ontop.walletservice.infrastructure.jpa.entity.WalletBankAccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletBankAccountEntityRepository extends CrudRepository<WalletBankAccountEntity, Long> {
}
