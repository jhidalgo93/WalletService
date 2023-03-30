package com.ontop.walletservice.domain.model.recipient;

import java.io.Serializable;

public class RecipientBankAccount implements Serializable {
    private Long id;
    private Long routingNumber;
    private Long accountNumber;

    private String bankName;

    private String holderFirstName;

    private String holderLastName;

    private Long holderNationalIdentificationNumber;

    private Long userId;

    public RecipientBankAccount(Long id, Long routingNumber, Long accountNumber, String bankName, String holderFirstName,
                                String holderLastName, Long holderNationalIdentificationNumber, Long userId) {
        this.id = id;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.holderFirstName = holderFirstName;
        this.holderLastName = holderLastName;
        this.holderNationalIdentificationNumber = holderNationalIdentificationNumber;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(Long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getHolderFirstName() {
        return holderFirstName;
    }

    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    public String getHolderLastName() {
        return holderLastName;
    }

    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
    }

    public Long getHolderNationalIdentificationNumber() {
        return holderNationalIdentificationNumber;
    }

    public void setHolderNationalIdentificationNumber(Long holderNationalIdentificationNumber) {
        this.holderNationalIdentificationNumber = holderNationalIdentificationNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
