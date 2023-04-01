package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.model.payment.PaymentState;

public interface PaymentRepository {

    Payment save(Payment payment, PaymentState paymentState);

}
