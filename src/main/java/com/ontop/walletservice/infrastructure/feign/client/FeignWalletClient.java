package com.ontop.walletservice.infrastructure.feign.client;

import com.ontop.walletservice.infrastructure.feign.model.wallet.UserBalance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wallet-api", url = "http://mockoon.tools.getontop.com:3000/wallets")
public interface FeignWalletClient {

    @GetMapping("/balance")
    UserBalance getUserBalance(@RequestParam ("user_id") Long userId);




}
