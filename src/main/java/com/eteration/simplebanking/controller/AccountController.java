package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@RestController
@RequestMapping("/account/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }
    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account account = accountService.findAccount(accountNumber);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber,
                                                    @RequestBody DepositTransaction depositTransaction)
            throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        if (account != null) {
            String approvalCode = accountService.deposit(account, depositTransaction);
            return ResponseEntity.ok(new TransactionStatus(ResponseStatusEnum.SUCCESS.getStatus(),
                    ResponseStatusEnum.SUCCESS.isSuccess(), approvalCode));//Enum
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber,
                                                   @RequestBody WithdrawalTransaction withdrawalTransaction)
            throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        if (account != null) {
            String approvalCode = accountService.withdrawal(account, withdrawalTransaction);
            return ResponseEntity.ok(new TransactionStatus(ResponseStatusEnum.SUCCESS.getStatus(),
                    ResponseStatusEnum.SUCCESS.isSuccess() ,approvalCode));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/debitPhoneBillPayment/{accountNumber}")
    public ResponseEntity<TransactionStatus> debitPhoneBillPayment(@PathVariable String accountNumber,
                                                   @RequestBody PhoneBillPaymentTransaction phoneBillPaymentTransaction)
            throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        if (account != null) {
            String approvalCode = accountService.withdrawalPhoneBillPayment(account, phoneBillPaymentTransaction);
            return ResponseEntity.ok(new TransactionStatus(ResponseStatusEnum.SUCCESS.getStatus(),
                    ResponseStatusEnum.SUCCESS.isSuccess(), approvalCode));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}