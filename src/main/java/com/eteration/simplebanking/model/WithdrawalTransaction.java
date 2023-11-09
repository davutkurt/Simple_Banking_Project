package com.eteration.simplebanking.model;


import javax.persistence.Entity;

// This class is a place holder you can change the complete implementation
@Entity
public class WithdrawalTransaction extends ConcreteTransaction {

    public WithdrawalTransaction(Double amount) {
        super(amount.doubleValue(), TransactionTypeEnum.WITHDRAWAL.getType(),
                TransactionTypeEnum.WITHDRAWAL.getDBalanceDirection());
    }

    public WithdrawalTransaction(int amount) {
        super(amount, TransactionTypeEnum.WITHDRAWAL.getType(),
                TransactionTypeEnum.WITHDRAWAL.getDBalanceDirection());
    }

    public WithdrawalTransaction() {
        super();
    }

}


