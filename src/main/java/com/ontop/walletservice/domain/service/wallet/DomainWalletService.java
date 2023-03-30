package com.ontop.walletservice.domain.service.wallet;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.domain.exception.GeneralErrorWalletException;
import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import com.ontop.walletservice.domain.model.wallet.WalletTransactionType;
import com.ontop.walletservice.domain.repository.WalletBankAccountRepository;
import com.ontop.walletservice.domain.repository.WalletTransactionRepository;

import java.time.LocalDateTime;

public class DomainWalletService implements WalletService {

    private final WalletClient walletClient;

    private final WalletTransactionRepository walletTransactionRepository;

    private final WalletBankAccountRepository walletBankAccountRepository;

    public DomainWalletService(WalletClient walletClient, WalletTransactionRepository walletTransactionRepository,
                               WalletBankAccountRepository walletBankAccountRepository) {
        this.walletClient = walletClient;
        this.walletTransactionRepository = walletTransactionRepository;
        this.walletBankAccountRepository = walletBankAccountRepository;
    }

    @Override
    public WalletTransaction createWithdrawWalletTransaction(Long userId, Double amount) {
        WalletTransaction walletTransaction =
                new WalletTransaction(walletClient.createWalletTransaction(userId, -amount), userId, -amount,
                        LocalDateTime.now(), WalletTransactionType.WITHDRAW, getCurrentWalletBankAccount());

        return  walletTransactionRepository.save(walletTransaction);
    }

    @Override
    public WalletTransaction createTopUpWalletTransaction(Long userId, Double amount) {

        WalletTransaction walletTransaction =
                new WalletTransaction(walletClient.createWalletTransaction(userId, amount), userId, amount,
                        LocalDateTime.now(), WalletTransactionType.TOP_UP, getCurrentWalletBankAccount());

        return  walletTransactionRepository.save(walletTransaction);
    }


    @Override
    public Double getWalletBalance(Long userId) {
        return walletClient.getWalletBalance(userId);
    }

    private WalletBankAccount getCurrentWalletBankAccount() {
        return walletBankAccountRepository.getCurrentWalletBankAccount()
                .orElseThrow(() -> new GeneralErrorWalletException("Unexpected error. it was not possible getting Wallet Bank Account"));
    }
}
