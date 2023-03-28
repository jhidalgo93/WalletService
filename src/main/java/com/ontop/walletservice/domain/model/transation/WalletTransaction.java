package com.ontop.walletservice.domain.model.transation;

import java.io.Serializable;

public class WalletTransaction extends Transaction implements Serializable {

    private Long walletTransactionId;


    public WalletTransaction(Long id, String status, Long userId, Double amount, Long walletTransactionId) {
        super(id, status, userId, amount);
        this.walletTransactionId = walletTransactionId;
    }

    public Long getWalletTransactionId() {
        return walletTransactionId;
    }

    public void setWalletTransactionId(Long walletTransactionId) {
        this.walletTransactionId = walletTransactionId;
    }
}
