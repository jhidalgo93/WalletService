package com.ontop.walletservice.infrastructure.feign.model.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletTransactionRequest {

    @JsonProperty("user_id")
    private Long userId;

    private Double amount;

}
