package com.ontop.walletservice.infrastructure.jpa.repository;

import com.ontop.walletservice.infrastructure.jpa.entity.BankAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountEntityRepository extends CrudRepository<BankAccountEntity, Long> {

    Optional<BankAccountEntity> findByUserId(Long userId);

}
