package com.eteration.simplebanking.Repository;

import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findAll();

    Account findByAccountNumber(String accountNumber);


}
