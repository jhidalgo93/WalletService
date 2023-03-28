package com.ontop.walletservice.infrastructure.feign.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PaymentAccountData implements Serializable {

    private Long accountNumber;
    private String currency;
    private Long routingNumber;

}
