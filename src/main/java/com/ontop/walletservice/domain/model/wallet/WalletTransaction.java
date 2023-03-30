package com.ontop.walletservice.domain.model.wallet;

import java.io.Serializable;
import java.time.LocalDateTime;

public class WalletTransaction implements Serializable {

    private Long id;

    private Long userId;

    private Double amount;

    private LocalDateTime created;

    private WalletTransactionType transactionType;

    private WalletBankAccount walletBankAccount;

    public WalletTransaction(){}

    public WalletTransaction(Long id, Long userId, Double amount, LocalDateTime created,
                             WalletTransactionType transactionType, WalletBankAccount walletBankAccount) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.created = created;
        this.transactionType = transactionType;
        this.walletBankAccount = walletBankAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public WalletTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(WalletTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public WalletBankAccount getWalletBankAccount() {
        return walletBankAccount;
    }

    public void setWalletBankAccount(WalletBankAccount walletBankAccount) {
        this.walletBankAccount = walletBankAccount;
    }
}
