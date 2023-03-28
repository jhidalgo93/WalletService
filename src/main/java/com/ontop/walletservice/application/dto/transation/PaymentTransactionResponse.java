package com.ontop.walletservice.application.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PaymentTransactionResponse extends TransactionResponse{

    @JsonProperty("payment_id")
    private Long paymentId;

    @JsonProperty("recipient_bank_account_id")
    private Long recipientBankAccountId;
    
}
