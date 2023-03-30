package com.ontop.walletservice.domain.model.payment;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PaymentState implements Serializable {

    private Integer stateId;

    private Payment payment;

    private String status;

    private LocalDateTime created;


    public PaymentState(Integer stateId, Payment payment, String status, LocalDateTime created) {
        this.stateId = stateId;
        this.payment = payment;
        this.status = status;
        this.created = created;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
