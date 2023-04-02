package com.ontop.walletservice.domain.service.payment;

import com.ontop.walletservice.domain.model.payment.Payment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PaymentService {

    Payment createPaymentTransaction(Long userId, Double amount);


    List<Payment> getAllPayments(Long userId, Double amount, LocalDateTime createdFrom, LocalDateTime createdTo,
                                 int pageSize, int offSet);

    void processAllPendingPayments();

}
