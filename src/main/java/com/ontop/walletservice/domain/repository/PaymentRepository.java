package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.payment.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);

}
