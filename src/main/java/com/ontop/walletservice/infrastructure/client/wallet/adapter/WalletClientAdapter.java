package com.ontop.walletservice.infrastructure.client.wallet.adapter;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.infrastructure.client.payment.mapper.PaymentProviderMapper;
import com.ontop.walletservice.infrastructure.client.wallet.FeignWalletClient;
import com.ontop.walletservice.infrastructure.client.wallet.dto.request.WalletTransactionRequest;
import com.ontop.walletservice.infrastructure.client.wallet.dto.response.WalletUserBalanceResponse;
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
