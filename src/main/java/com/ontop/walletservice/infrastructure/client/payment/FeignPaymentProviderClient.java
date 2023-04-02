package com.ontop.walletservice.infrastructure.client.payment;

import com.ontop.walletservice.infrastructure.client.payment.dto.request.PaymentProviderRequest;
import com.ontop.walletservice.infrastructure.client.payment.dto.response.PaymentProviderResponse;
import com.ontop.walletservice.infrastructure.client.payment.dto.response.PaymentProviderStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-api", url = "http://mockoon.tools.getontop.com:3000/api/v1/payments")
public interface FeignPaymentProviderClient {

    @PostMapping
    PaymentProviderResponse createPaymentProvider(@RequestBody PaymentProviderRequest paymentProviderRequest);


    @GetMapping(path = "/{paymentId}/status")
    PaymentProviderStatus getPaymentStatus(@PathVariable("paymentId") String paymentId);

}
