package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.wallet.WalletTransaction;

public interface WalletTransactionRepository {

    WalletTransaction save(WalletTransaction walletTransaction);

}
