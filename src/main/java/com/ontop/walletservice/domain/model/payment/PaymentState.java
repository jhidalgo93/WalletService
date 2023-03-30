package com.ontop.walletservice.domain.model.payment;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PaymentState implements Serializable {

    private Integer stateId;

    private String paymentId;
    private String status;

    private LocalDateTime created;


    public PaymentState(Integer stateId, String paymentId, String status, LocalDateTime created) {
        this.stateId = stateId;
        this.paymentId = paymentId;
        this.status = status;
        this.created = created;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
