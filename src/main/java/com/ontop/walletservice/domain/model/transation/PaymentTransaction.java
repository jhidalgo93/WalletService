package com.ontop.walletservice.domain.model.transation;

import com.ontop.walletservice.infrastructure.feign.model.payment.PaymentSourceProvider;

import java.io.Serializable;

public class PaymentTransaction extends Transaction implements Serializable  {

    private Long paymentId;

    private Long recipientBankAccountId;

    public PaymentTransaction() {
        super();
    }

    public PaymentTransaction(Long id, String status, Long userId, Double amount,
                              Long paymentId, Long recipientBankAccountId, PaymentSourceProvider sourceProvider) {
        super(id, status, userId, amount);
        this.paymentId = paymentId;
        this.recipientBankAccountId = recipientBankAccountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRecipientBankAccountId() {
        return recipientBankAccountId;
    }

    public void setRecipientBankAccountId(Long recipientBankAccountId) {
        this.recipientBankAccountId = recipientBankAccountId;
    }
}
