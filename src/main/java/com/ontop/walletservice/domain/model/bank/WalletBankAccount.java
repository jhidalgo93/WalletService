package com.ontop.walletservice.domain.model.bank;

import java.io.Serializable;

public class WalletBankAccount implements Serializable {

    private Long id;
    private String type;
    private String name;

    private String accountNumber;

    private String currency;

    private String routingNumber;


    public WalletBankAccount(Long id, String type, String name, String accountNumber, String currency, String routingNumber) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.routingNumber = routingNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }
}
