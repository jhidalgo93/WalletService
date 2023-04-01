package com.ontop.walletservice.infrastructure.repository.payment.mapper;

import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentRepositoryMapper {

    PaymentRepositoryMapper INSTANCE = Mappers.getMapper(PaymentRepositoryMapper.class);

    PaymentEntity toPaymentEntity(Payment payment);

    Payment toPayment(PaymentEntity paymentEntity);


}
