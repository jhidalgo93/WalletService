package com.ontop.walletservice.domain.service.transation;

import com.ontop.walletservice.domain.model.transation.PaymentTransaction;

public interface PaymentTransactionService {

    PaymentTransaction createPaymentTransaction(Long userId, Double amount);

}
