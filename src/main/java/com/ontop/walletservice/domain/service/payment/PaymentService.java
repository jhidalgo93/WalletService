package com.ontop.walletservice.domain.service.payment;

import com.ontop.walletservice.domain.model.payment.Payment;

public interface PaymentService {

    Payment createPaymentTransaction(Long userId, Double amount);

}
