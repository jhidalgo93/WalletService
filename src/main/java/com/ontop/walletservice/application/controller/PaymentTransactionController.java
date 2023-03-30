package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.transation.PaymentTransactionRequest;
import com.ontop.walletservice.application.dto.transation.PaymentTransactionResponse;
import com.ontop.walletservice.application.mapper.PaymentMapper;
import com.ontop.walletservice.domain.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/user/{user_id}/payment-transactions")
public class PaymentTransactionController {


    private final PaymentService paymentService;

    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @PostMapping
    public PaymentTransactionResponse createPaymentTransaction(@PathVariable("user_id") long userId,
            @RequestBody @Valid PaymentTransactionRequest paymentTransactionRequest) {

        return paymentMapper.toPaymentTransactionResponse(
                paymentService.createPaymentTransaction(userId, paymentTransactionRequest.getAmount()));
    }


    @GetMapping
    public List<PaymentTransactionResponse> getTransactions(@PathVariable long userId) {

        return null;
    }


    @GetMapping(path = "/cost/{amount}")
    public List<PaymentTransactionResponse> getCostTransaction(@PathVariable Double amount) {

        return null;
    }


}
