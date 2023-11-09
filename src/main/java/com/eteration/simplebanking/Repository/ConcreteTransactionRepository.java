package com.eteration.simplebanking.Repository;

import com.eteration.simplebanking.model.ConcreteTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcreteTransactionRepository extends JpaRepository<ConcreteTransaction, Long> {

    List<ConcreteTransaction> findAll();


}
