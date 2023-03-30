package com.ontop.walletservice.domain.model.payment;

import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Payment implements Serializable  {

    private String id;

    private RecipientBankAccount bankAccount;

    private Long userId;

    private Double amount;

    private LocalDateTime createDate;

    private WalletTransaction walletTransaction;

    private List<PaymentState> paymentStates;

    public Payment() {
    }

    public Payment(String id, RecipientBankAccount bankAccount, Long userId, Double amount, LocalDateTime createDate,
                   WalletTransaction walletTransaction, List<PaymentState> paymentStates) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.userId = userId;
        this.amount = amount;
        this.createDate = createDate;
        this.walletTransaction = walletTransaction;
        this.paymentStates = paymentStates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public RecipientBankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(RecipientBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<PaymentState> getPaymentStates() {
        return paymentStates;
    }

    public void setPaymentStates(List<PaymentState> paymentStates) {
        this.paymentStates = paymentStates;
    }

    public WalletTransaction getWalletTransaction() {
        return walletTransaction;
    }

    public void setWalletTransaction(WalletTransaction walletTransaction) {
        this.walletTransaction = walletTransaction;
    }
}
