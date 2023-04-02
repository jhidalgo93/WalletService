package com.ontop.walletservice.infrastructure.repository.payment;

import com.ontop.walletservice.infrastructure.repository.payment.entity.PaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentEntityRepository extends CrudRepository<PaymentEntity, Long> {

    @Query(value = "SELECT p.* FROM payment p " +
            "JOIN payment_state ps ON p.id = ps.payment_id " +
            "WHERE ps.id = (SELECT ps2.id FROM payment_state ps2 WHERE ps2.payment_id = p.id ORDER BY ps2.created DESC LIMIT 1) " +
            "AND ps.status = 'PROCESSING'", nativeQuery = true)
    List<PaymentEntity> getAllPendingPayments();

}
