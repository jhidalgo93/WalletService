package com.ontop.walletservice.application.mapper;

import com.ontop.walletservice.application.dto.transation.PaymentTransactionResponse;
import com.ontop.walletservice.domain.model.transation.PaymentTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);


    PaymentTransactionResponse toPaymentTransactionResponse(PaymentTransaction paymentTransaction);

}
