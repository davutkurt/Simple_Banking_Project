package com.eteration.simplebanking.model;

public enum TransactionTypeEnum {
    WITHDRAWAL("WithdrawalTransaction", "WITHDRAW"),
    DEPOSIT("DepositTransaction", "DEPOSIT"),
    PHONEBILLPAYMENT("PhoneBillPaymentTransaction", "WITHDRAW");

    private String type;
    private String balanceDirection;

    TransactionTypeEnum(String type, String balanceDirection) {
        this.type = type;
        this.balanceDirection = balanceDirection;
    }

    public String getType() {
        return type;
    }

    public String getDBalanceDirection() {
        return balanceDirection;
    }

}
