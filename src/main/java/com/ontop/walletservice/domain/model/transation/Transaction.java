package com.ontop.walletservice.domain.model.transation;

public abstract class Transaction {

    protected Long id;

    protected String status;


    protected Long userId;

    protected Double amount;


    public Transaction() {

    }
    public Transaction(Long id, String status, Long userId, Double amount) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
