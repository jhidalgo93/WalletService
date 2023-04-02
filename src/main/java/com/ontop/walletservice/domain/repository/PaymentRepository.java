package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.model.payment.PaymentState;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentRepository {

    Payment save(Payment payment, PaymentState paymentState);

    PaymentState savePaymentState(PaymentState paymentState);

    List<Payment> getAllPendingPayments();

    List<Payment> getAllPayments(Long userId,Double amount, LocalDateTime createdFrom, LocalDateTime createdTo,
                                 int pageSize, int offSet);


}
