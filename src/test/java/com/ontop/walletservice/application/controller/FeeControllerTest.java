package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.fee.FeeResponse;
import com.ontop.walletservice.domain.model.fee.TransactionFee;
import com.ontop.walletservice.domain.service.fee.FeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

public class FeeControllerTest {

    @Mock
    private FeeService feeService;

    @InjectMocks
    private FeeController feeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateFee() {
        Double amount = 1000.0;
        Double initialAmount = 1000.0;
        Double transactionFee = 50.0;
        Double finalAmount = 950.0;

        when(feeService.calculateFee(anyDouble()))
                .thenReturn(new TransactionFee(initialAmount, transactionFee, finalAmount));

        FeeResponse feeResponse = feeController.getCostFee(amount);
        assertEquals(initialAmount, feeResponse.getInitialAmount());
        assertEquals(transactionFee, feeResponse.getTransactionFee());
        assertEquals(finalAmount, feeResponse.getFinalAmount());
    }
}