package com.ontop.walletservice.infrastructure.repository.recipient;

import com.ontop.walletservice.infrastructure.repository.recipient.entity.RecipientBankAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipientBankAccountEntityRepository extends CrudRepository<RecipientBankAccountEntity, Long> {

    Optional<RecipientBankAccountEntity> findByUserId(Long userId);

}
