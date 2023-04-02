package com.ontop.walletservice.domain.model.payment;

public enum PaymentStatus {
    PROCESSING,
    COMPLETED,
    REFOUNDED,
    FAILED;


    public static PaymentStatus fromString(String status) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.name().equalsIgnoreCase(status)) {
                return paymentStatus;
            }
        }
        throw new IllegalArgumentException("Invalid payment status: " + status);
    }

}
