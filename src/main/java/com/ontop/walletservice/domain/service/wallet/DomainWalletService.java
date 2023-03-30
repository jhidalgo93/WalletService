package com.ontop.walletservice.domain.service.wallet;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import com.ontop.walletservice.domain.repository.WalletTransactionRepository;

public class DomainWalletService implements WalletService {

    private final WalletClient walletClient;

    private final WalletTransactionRepository walletTransactionRepository;

    public DomainWalletService(WalletClient walletClient, WalletTransactionRepository walletTransactionRepository) {
        this.walletClient = walletClient;
        this.walletTransactionRepository = walletTransactionRepository;
    }

    @Override
    public WalletTransaction createWalletTransaction(Long userId, Double amount) {
         Long walletTransactionId = walletClient.createWalletTransaction(userId, amount);

         return null;
    }

    @Override
    public Double getWalletBalance(Long userId) {
        return walletClient.getWalletBalance(userId);
    }
}
