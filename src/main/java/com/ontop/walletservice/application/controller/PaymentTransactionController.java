package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.transation.PaymentTransactionRequest;
import com.ontop.walletservice.application.dto.transation.PaymentTransactionResponse;
import com.ontop.walletservice.application.mapper.PaymentMapper;
import com.ontop.walletservice.domain.model.transation.PaymentTransaction;
import com.ontop.walletservice.domain.service.transation.PaymentTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/payment-transactions")
public class PaymentTransactionController {


    private final PaymentTransactionService paymentTransactionService;

    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @PostMapping
    public PaymentTransactionResponse createPaymentTransaction(
            @RequestBody @Valid PaymentTransactionRequest paymentTransactionRequest) {

        return paymentMapper.toPaymentTransactionResponse(
                paymentTransactionService.createPaymentTransaction(paymentTransactionRequest.getUserId(),
                        paymentTransactionRequest.getAmount()));
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
