package com.ontop.walletservice.domain.model.wallet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WalletTransaction implements Serializable {

    private String id;

    private Long userId;

    private BigDecimal amount;

    private LocalDateTime created;

    private WalletTransactionType transactionType;


    public WalletTransaction(String id, Long userId, BigDecimal amount, LocalDateTime created, WalletTransactionType transactionType) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.created = created;
        this.transactionType = transactionType;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
}
