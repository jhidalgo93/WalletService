package com.ontop.walletservice.infrastructure.repository.payment;

import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentStateEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentStateEntityRepository extends CrudRepository<PaymentStateEntity, Long> {
}
