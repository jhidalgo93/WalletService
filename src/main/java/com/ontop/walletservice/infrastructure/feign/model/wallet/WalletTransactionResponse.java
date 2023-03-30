package com.ontop.walletservice.infrastructure.feign.model.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletTransactionResponse {

    @JsonProperty("wallet_transaction_id")
    private Long walletTransactionId;

    @JsonProperty("user_id")
    private Long userId;

    private Double amount;

}