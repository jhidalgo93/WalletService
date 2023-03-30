package com.ontop.walletservice.infrastructure.feign.client.adapter;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.infrastructure.feign.client.FeignWalletClient;
import com.ontop.walletservice.infrastructure.feign.model.wallet.WalletTransactionRequest;
import com.ontop.walletservice.infrastructure.feign.model.wallet.WalletUserBalanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class WalletClientAdapter implements WalletClient {

    private final FeignWalletClient feignWalletClient;


    @Override
    public Double getWalletBalance(Long userId) {
        WalletUserBalanceResponse walletUserBalanceResponse = feignWalletClient.getWalletUserBalance(userId);
        return walletUserBalanceResponse.getBalance();
    }

    @Override
    public Long createWalletTransaction(Long userId, Double amount) {
        return feignWalletClient.createWalletTransaction(new WalletTransactionRequest(userId, amount))
                .getWalletTransactionId();
    }


}
