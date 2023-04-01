package com.ontop.walletservice.infrastructure.repository.payment.adapter;

import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.model.payment.PaymentState;
import com.ontop.walletservice.domain.repository.PaymentRepository;
import com.ontop.walletservice.infrastructure.repository.payment.PaymentEntityRepository;
import com.ontop.walletservice.infrastructure.repository.payment.PaymentStateEntityRepository;
import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentEntity;
import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentStateEntity;
import com.ontop.walletservice.infrastructure.repository.payment.mapper.PaymentRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {


    private final PaymentEntityRepository paymentEntityRepository;

    private final PaymentStateEntityRepository paymentStateEntityRepository;

    private final PaymentRepositoryMapper paymentRepositoryMapper = PaymentRepositoryMapper.INSTANCE;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment save(Payment payment) {
        PaymentEntity paymentEntity = paymentRepositoryMapper.toPaymentEntity(payment);

        PaymentEntity createdPayment = paymentEntityRepository.save(paymentEntity);
        PaymentStateEntity paymentState = paymentEntity.getPaymentStates().get(0);
        paymentState.setPayment(createdPayment);
        PaymentStateEntity createPaymentState = paymentStateEntityRepository.save(paymentState);

        createdPayment.setPaymentStates(List.of(createPaymentState));

        Payment response = paymentRepositoryMapper.toPayment(createdPayment);

        return response;
    }
}
