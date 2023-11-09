package com.eteration.simplebanking.model;


import javax.persistence.Entity;

// This class is a place holder you can change the complete implementation
@Entity
public class DepositTransaction extends ConcreteTransaction {

    public DepositTransaction(Double amount) {
        super(amount, TransactionTypeEnum.DEPOSIT.getType(), TransactionTypeEnum.DEPOSIT.getDBalanceDirection());
    }

    public DepositTransaction(int amount) {
        super(amount, TransactionTypeEnum.DEPOSIT.getType(), TransactionTypeEnum.DEPOSIT.getDBalanceDirection());
    }

    public DepositTransaction() {
        super();
    }

}
