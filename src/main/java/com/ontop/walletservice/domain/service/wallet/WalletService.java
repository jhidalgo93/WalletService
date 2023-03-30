package com.ontop.walletservice.domain.service.wallet;

import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;

public interface WalletService {

    WalletTransaction createWithdrawWalletTransaction(Long userId, Double amount);

    WalletTransaction createTopUpWalletTransaction(Long userId, Double amount);


    Double getWalletBalance(Long userId);
}
