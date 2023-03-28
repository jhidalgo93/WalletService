package com.ontop.walletservice.infrastructure.feign.model.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserBalance implements Serializable {

    private Double balance;
    @JsonProperty("user_id")
    private Long userId;
}
