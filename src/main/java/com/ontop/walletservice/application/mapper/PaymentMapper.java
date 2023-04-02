package com.ontop.walletservice.application.mapper;

import com.ontop.walletservice.application.dto.payment.PaymentResponse;
import com.ontop.walletservice.domain.model.payment.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "transactionId", target = "transactionId")
    @Mapping(source = "bankAccount.id", target = "recipientBankAccountId")
    @Mapping(expression = "java(payment.getPaymentStates().isEmpty() ? null : payment.getPaymentStates().get(0).getStatus())", target = "status")
    @Mapping(source = "amount", target = "amount")
    PaymentResponse toPaymentTransactionResponse(Payment payment);

}
