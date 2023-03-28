package com.ontop.walletservice.domain.service;

import com.ontop.walletservice.domain.model.PaymentTransaction;

public interface PaymentTransactionService {

    PaymentTransaction createPaymentTransaction(PaymentTransaction paymentTransaction);

}
