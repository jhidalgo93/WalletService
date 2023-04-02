package com.ontop.walletservice.infrastructure.client.payment.adapter;

import com.ontop.walletservice.domain.client.PaymentProviderClient;
import com.ontop.walletservice.domain.model.payment.PaymentProvider;
import com.ontop.walletservice.domain.model.payment.PaymentStatus;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;
import com.ontop.walletservice.infrastructure.client.payment.FeignPaymentProviderClient;
import com.ontop.walletservice.infrastructure.client.payment.dto.request.PaymentDestinationProvider;
import com.ontop.walletservice.infrastructure.client.payment.dto.request.PaymentProviderRequest;
import com.ontop.walletservice.infrastructure.client.payment.dto.request.PaymentSourceProvider;
import com.ontop.walletservice.infrastructure.client.payment.dto.response.PaymentProviderResponse;
import com.ontop.walletservice.infrastructure.client.payment.dto.response.PaymentProviderStatus;
import com.ontop.walletservice.infrastructure.client.payment.mapper.PaymentProviderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PaymentProviderAdapter implements PaymentProviderClient {


    private final FeignPaymentProviderClient feignPaymentProviderClient;


    private final PaymentProviderMapper paymentProviderMapper = PaymentProviderMapper.INSTACE;


    @Override
    public PaymentProvider createPaymentProvider(WalletBankAccount originBank, RecipientBankAccount recipientBank,
                                                 Double amount) {
        PaymentSourceProvider paymentSourceProvider = paymentProviderMapper.toPaymentSourceProvider(originBank);
        PaymentDestinationProvider paymentDestinationProvider = paymentProviderMapper.toPaymentDestinationProvider(recipientBank);

        PaymentProviderRequest paymentProviderRequest = new PaymentProviderRequest(paymentSourceProvider,
                paymentDestinationProvider, amount);

        PaymentProviderResponse response = feignPaymentProviderClient.createPaymentProvider(paymentProviderRequest);
        return paymentProviderMapper.toPaymentProvider(response);
    }

    @Override
    public PaymentStatus getPaymentStatus(String paymentId) {
        PaymentProviderStatus paymentProviderStatus = feignPaymentProviderClient.getPaymentStatus(paymentId);
        return PaymentStatus.fromString(paymentProviderStatus.getStatus().toUpperCase());
    }
}
