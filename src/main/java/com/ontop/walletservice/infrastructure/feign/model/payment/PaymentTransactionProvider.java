package com.ontop.walletservice.infrastructure.feign.payment.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PaymentTransactionProvider implements Serializable {

    private Double amount;

    private PaymentSourceProvider source;

    private PaymentDestinationProvider destination;

}
