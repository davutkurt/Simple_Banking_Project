package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(unique = true)
    private String accountNumber;
    @Column
    private String owner;
    @Column
    private Double balance = 0d;
    @Column
    private Timestamp acoountCreateDate;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<ConcreteTransaction> transactions = new LinkedList<>();

    public Account(){
        this.acoountCreateDate = new Timestamp(System.currentTimeMillis());
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.acoountCreateDate = new Timestamp(System.currentTimeMillis());
    }

    public void deposit(Double deposit){
        this.balance = balance + deposit;
    }

    public void deposit(int deposit){
        this.balance = balance + deposit;
    }

    public void withdraw(Double withdraw) throws InsufficientBalanceException {
        if(Math.abs(balance) < Math.abs(withdraw)){
            throw new InsufficientBalanceException();
        }
        this.balance = balance - withdraw;
    }

    public void withdraw(int withdraw) throws InsufficientBalanceException {
        withdraw = Math.abs(withdraw);
        if(balance < withdraw){
            throw new InsufficientBalanceException();
        }
        this.balance = balance - withdraw;
    }
    public void post(ConcreteTransaction transaction) throws InsufficientBalanceException {
        if("WITHDRAW".equalsIgnoreCase(transaction.getBalanceDirection())){
            withdraw(Math.abs(transaction.getAmount()));
        } else {
            deposit(transaction.getAmount());
        }
        transactions.add(transaction);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Timestamp getAcoountCreateDate() {
        return acoountCreateDate;
    }

    public void setAcoountCreateDate(Timestamp acoountCreateDate) {
        this.acoountCreateDate = acoountCreateDate;
    }

    public List<ConcreteTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ConcreteTransaction> transactions) {
        this.transactions = transactions;
    }
}
