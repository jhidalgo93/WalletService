package com.ontop.walletservice.infrastructure.feign.client.adapter;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.infrastructure.feign.client.FeignWalletClient;
import com.ontop.walletservice.infrastructure.feign.model.wallet.UserBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class WalletClientAdapter implements WalletClient {

    private final FeignWalletClient feignWalletClient;


    @Override
    public Double getUserBalance(Long userId) {
        UserBalance userBalance = feignWalletClient.getUserBalance(userId);
        return userBalance.getBalance();
    }
}
