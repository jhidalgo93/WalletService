package com.ontop.walletservice.infrastructure.repository.payment;

import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentEntityRepository extends CrudRepository<PaymentEntity, Long> {
}
