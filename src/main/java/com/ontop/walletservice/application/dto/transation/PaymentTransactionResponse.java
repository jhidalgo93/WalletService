package com.ontop.walletservice.application.dto.transation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class PaymentTransactionResponse extends TransactionResponse {

    @JsonProperty("payment_id")
    private Long paymentId;

    @JsonProperty("recipient_bank_account_id")
    private Long recipientBankAccountId;

}
