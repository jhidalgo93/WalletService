package com.ontop.walletservice.infrastructure.repository.payment.adapter;

import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.repository.PaymentRepository;
import com.ontop.walletservice.infrastructure.repository.payment.PaymentEntityRepository;
import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentEntity;
import com.ontop.walletservice.infrastructure.repository.payment.mapper.PaymentRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {


    private final PaymentEntityRepository paymentEntityRepository;

    private final PaymentRepositoryMapper paymentRepositoryMapper = PaymentRepositoryMapper.INSTANCE;


    @Override
    @Transactional(propagation = Propagation.NESTED)
    public Payment save(Payment payment) {
        PaymentEntity paymentEntity = paymentRepositoryMapper.toPaymentEntity(payment);
        Payment createdPayment = paymentRepositoryMapper.toPayment(paymentEntityRepository.save(paymentEntity));
        return createdPayment;
    }
}
