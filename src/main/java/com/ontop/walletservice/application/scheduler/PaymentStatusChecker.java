package com.ontop.walletservice.application.scheduler;

import com.ontop.walletservice.domain.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentStatusChecker {

    private final PaymentService paymentService;

    @Async
    @Scheduled(fixedDelayString = "${payment.check}" )
    public void processPayments() {
        paymentService.processAllPendingPayments();
    }

}
