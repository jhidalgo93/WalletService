package com.ontop.walletservice.domain.service.wallet;

import com.ontop.walletservice.domain.model.wallet.WalletTransaction;

public interface WalletService {

    WalletTransaction createWalletTransaction(Long userId, Double amount);

    Double getWalletBalance(Long userId);
}
