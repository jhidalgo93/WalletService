package com.ontop.walletservice.application.dto.transation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTransactionRequest {

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull(message = "User id cannot be null")
    private Long userId;

}
