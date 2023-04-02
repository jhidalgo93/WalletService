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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {


    private final PaymentEntityRepository paymentEntityRepository;

    private final PaymentStateEntityRepository paymentStateEntityRepository;

    private final PaymentRepositoryMapper paymentRepositoryMapper = PaymentRepositoryMapper.INSTANCE;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment save(Payment payment, PaymentState paymentState) {
        PaymentEntity paymentEntity = paymentRepositoryMapper.toPaymentEntity(payment);
        paymentEntity.setCreated(LocalDateTime.now());

        PaymentStateEntity paymentStateEntity = paymentRepositoryMapper.toPaymentStateEntityIgnorePayment(paymentState);
        paymentStateEntity.setCreated(LocalDateTime.now());

        paymentStateEntity.setPayment(paymentEntity);
        paymentEntity.setPaymentStates(List.of(paymentStateEntity));

        PaymentEntity createdPayment = paymentEntityRepository.save(paymentEntity);

        Payment response = paymentRepositoryMapper.toPayment(createdPayment);

        return response;
    }

    @Override
    @Transactional
    public PaymentState savePaymentState(PaymentState paymentState) {
        PaymentStateEntity paymentStateEntity = paymentRepositoryMapper.toPaymentStateEntity(paymentState);
        return paymentRepositoryMapper.toPaymentState(paymentStateEntityRepository.save(paymentStateEntity));
    }

    @Override
    @Transactional
    public List<Payment> getAllPendingPayments() {
        return paymentEntityRepository.getAllPendingPayments()
                .stream()
                .map(paymentRepositoryMapper::toPayment)
                .collect(Collectors.toList());
    }

    @Override
    public List<Payment> getAllPayments(Long userId, Double amount, LocalDateTime createdFrom, LocalDateTime createdTo, int pageSize, int offSet) {
        return paymentEntityRepository.findPayments(amount, createdFrom, createdTo, userId, pageSize, offSet)
                .stream()
                .map(paymentRepositoryMapper::toPayment)
                .collect(Collectors.toList());
    }


}
