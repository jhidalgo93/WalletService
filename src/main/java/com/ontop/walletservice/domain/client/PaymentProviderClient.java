package com.ontop.walletservice.domain.client;

import com.ontop.walletservice.domain.model.payment.PaymentProvider;
import com.ontop.walletservice.domain.model.payment.PaymentStatus;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;

public interface PaymentProviderClient {

    PaymentProvider createPaymentProvider(WalletBankAccount originBank, RecipientBankAccount  recipientBank,
                                          Double amount);

    PaymentStatus getPaymentStatus(String paymentId);


}
