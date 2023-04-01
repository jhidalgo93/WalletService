package com.ontop.walletservice.domain.model.payment;

import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment implements Serializable  {

    private Long id;
    private String transactionId;

    private RecipientBankAccount bankAccount;

    private Long userId;

    private Double amount;

    private LocalDateTime createDate;

    private WalletTransaction walletTransaction;

    private List<PaymentState> paymentStates;

}
