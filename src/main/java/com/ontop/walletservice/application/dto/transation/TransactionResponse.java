package com.ontop.walletservice.application.dto.transation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class TransactionResponse {

    protected Long id;

    protected String status;


    @JsonProperty("user_id")
    protected Long userId;

    protected Double amount;

}
