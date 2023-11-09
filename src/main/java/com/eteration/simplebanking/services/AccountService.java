package com.eteration.simplebanking.services;


import com.eteration.simplebanking.Repository.AccountRepository;
import com.eteration.simplebanking.Repository.ConcreteTransactionRepository;
import com.eteration.simplebanking.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

// This class is a place holder you can change the complete implementation
@Service
@RequiredArgsConstructor
public class AccountService {

    private final HashMap<String, Account> accounts;
    private final AccountRepository accountRepository;
    private final ConcreteTransactionRepository concreteTransactionRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, ConcreteTransactionRepository concreteTransactionRepository) {
        accounts = new HashMap<>();
        this.accountRepository = accountRepository;
        this.concreteTransactionRepository = concreteTransactionRepository;
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    public Account findAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public String deposit(Account account, DepositTransaction depositTransactionDTO)
            throws InsufficientBalanceException {
        DepositTransaction depositTransaction = new DepositTransaction(depositTransactionDTO.getAmount());
        depositTransaction.setAccount(account);
        account.post(depositTransaction);
        accountRepository.save(account);
        concreteTransactionRepository.save(depositTransaction);
        return depositTransaction.getApprovalCode();
    }

    public String withdrawal(Account account, WithdrawalTransaction withdrawalTransactionDTO)
            throws InsufficientBalanceException {
        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(withdrawalTransactionDTO.getAmount());
        withdrawalTransaction.setAccount(account);
        account.post(withdrawalTransaction);
        accountRepository.save(account);
        concreteTransactionRepository.save(withdrawalTransaction);
        return withdrawalTransaction.getApprovalCode();
    }

    public String withdrawalPhoneBillPayment(Account account, PhoneBillPaymentTransaction phoneBillPaymentTransactionDTO)
            throws InsufficientBalanceException {
        PhoneBillPaymentTransaction phoneBillPaymentTransaction =
                new PhoneBillPaymentTransaction(phoneBillPaymentTransactionDTO.getTelecomCompanyName(),
                        phoneBillPaymentTransactionDTO.getPhoneNumber(),
                        phoneBillPaymentTransactionDTO.getAmount());
        phoneBillPaymentTransaction.setAccount(account);
        account.post(phoneBillPaymentTransaction);
        accountRepository.save(account);
        concreteTransactionRepository.save(phoneBillPaymentTransaction);
        return phoneBillPaymentTransaction.getApprovalCode();
    }
}
