package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.payment.PaymentRequest;
import com.ontop.walletservice.application.dto.payment.PaymentResponse;
import com.ontop.walletservice.application.mapper.PaymentMapper;
import com.ontop.walletservice.domain.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/user/{user_id}/payments")
public class PaymentController {

    private final PaymentService paymentService;

    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createPaymentTransaction(@PathVariable("user_id") long userId,
                                                    @RequestBody @Valid PaymentRequest paymentRequest) {

        return paymentMapper.toPaymentTransactionResponse(
                paymentService.createPaymentTransaction(userId, paymentRequest.getAmount()));
    }


    @GetMapping
    public List<PaymentResponse> getTransactions(@PathVariable long userId) {

        return null;
    }

}
