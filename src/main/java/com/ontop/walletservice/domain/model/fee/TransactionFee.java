package com.ontop.walletservice.domain.model.fee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionFee {

    private Double initialAmount;
    private Double transactionFee;

    private Double finalAmount;
}
