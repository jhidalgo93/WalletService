package com.ontop.walletservice.domain.service.fee;

import com.ontop.walletservice.domain.model.fee.TransactionFee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DomainFeeServiceTest {

    @Test
    public void testCalculateFee() {
        // arrange
        DomainFeeService domainFeeService = new DomainFeeService();
        Double initialAmount = 100.0;

        // act
        TransactionFee transactionFee = domainFeeService.calculateFee(initialAmount);

        // assert
        assertNotNull(transactionFee);
        assertEquals(initialAmount, transactionFee.getInitialAmount());
        assertEquals(initialAmount*0.10, transactionFee.getTransactionFee());
        assertEquals(initialAmount - (initialAmount*0.10), transactionFee.getFinalAmount());
    }
}
