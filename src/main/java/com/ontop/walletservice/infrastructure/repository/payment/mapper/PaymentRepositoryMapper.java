package com.ontop.walletservice.infrastructure.repository.payment.mapper;

import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.model.payment.PaymentState;
import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentEntity;
import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentStateEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentRepositoryMapper {

    PaymentRepositoryMapper INSTANCE = Mappers.getMapper(PaymentRepositoryMapper.class);

    @IterableMapping(qualifiedByName = "mapPaymentStateToPaymentStateEntity")
    List<PaymentStateEntity> mapPaymentStateListToPaymentStateEntityList(List<PaymentState> paymentStates);

    @Named("mapPaymentStateToPaymentStateEntity")
    default PaymentStateEntity mapPaymentStateToPaymentStateEntity(PaymentState paymentState) {
        PaymentStateEntity paymentStateEntity = new PaymentStateEntity();
        paymentStateEntity.setStatus(paymentState.getStatus());
        paymentStateEntity.setCreated(paymentState.getCreated());
        return paymentStateEntity;
    }

    @Mapping(target = "paymentStates", source = "paymentStates")
    PaymentEntity toPaymentEntity(Payment payment);

    @IterableMapping(qualifiedByName = "mapPaymentStateToPaymentState")
    List<PaymentState> mapPaymentStateListToPaymentStateList(List<PaymentStateEntity> paymentStates);

    @Named("mapPaymentStateToPaymentState")
    default PaymentState mapPaymentStateToPaymentState(PaymentStateEntity paymentStateEntity) {
        PaymentState paymentState = new PaymentState();
        paymentState.setId(paymentStateEntity.getId());
        paymentState.setStatus(paymentStateEntity.getStatus());
        paymentState.setCreated(paymentStateEntity.getCreated());
        return paymentState;
    }


    @Mapping(target = "paymentStates", source = "paymentStates")
    Payment toPayment(PaymentEntity paymentEntity);


}
