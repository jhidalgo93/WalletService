package com.ontop.walletservice.domain.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentProvider {

    private String id;
    private String status;

    private Double amount;
}
