package com.ontop.walletservice.domain.client;

public interface WalletClient {

    Double getWalletBalance(Long userId);


    Long createWalletTransaction(Long userId, Double amount);
}
