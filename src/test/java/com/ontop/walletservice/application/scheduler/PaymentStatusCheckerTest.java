package com.ontop.walletservice.application.scheduler;

import static org.mockito.Mockito.*;

import com.ontop.walletservice.domain.service.payment.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PaymentStatusCheckerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentStatusChecker paymentStatusChecker;

    @Test
    public void testProcessPayments() {
        paymentStatusChecker.processPayments();
        verify(paymentService, times(1)).processAllPendingPayments();
    }

}
