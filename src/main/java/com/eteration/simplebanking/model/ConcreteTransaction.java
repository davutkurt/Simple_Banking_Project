package com.eteration.simplebanking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "TRANSACTION")
public class ConcreteTransaction extends Transaction {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column
    Timestamp date;
    @Column
    Double amount = 0d;
    @Column
    String transactionType;
    @Column
    @JsonIgnore
    String balanceDirection;
    @Column
    String approvalCode;
    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    @JsonBackReference
    private Account account;


    public ConcreteTransaction() {
    }

    public ConcreteTransaction(Double amount, String transactionType, String balanceDirection) {
        this.amount = amount;
        this.date = new Timestamp(System.currentTimeMillis());
        this.transactionType = transactionType;
        this.balanceDirection = balanceDirection;
        this.approvalCode = generateApprovalCode();
    }

    public ConcreteTransaction(int amount, String transactionType, String balanceDirection) {
        this.amount = (double) amount;
        this.date = new Timestamp(System.currentTimeMillis());
        this.transactionType = transactionType;
        this.balanceDirection = balanceDirection;
        this.approvalCode = generateApprovalCode();
    }

    public Timestamp getDate() {
        if (date == null) {
            date = new Timestamp(System.currentTimeMillis());
        }
        return date;
    }

    public String generateApprovalCode() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getBalanceDirection() {
        return balanceDirection;
    }

    public void setBalanceDirection(String balanceDirection) {
        this.balanceDirection = balanceDirection;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
