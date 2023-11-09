package com.eteration.simplebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PhoneBillPaymentTransaction extends ConcreteTransaction {
    @Column
    String telecomCompanyName;
    @Column
    String phoneNumber;

    public PhoneBillPaymentTransaction(String telecomCompanyName, String phoneNumber, Double amount) {
        super(amount.doubleValue(), TransactionTypeEnum.PHONEBILLPAYMENT.getType(),
                TransactionTypeEnum.PHONEBILLPAYMENT.getDBalanceDirection());
        this.telecomCompanyName = telecomCompanyName;
        this.phoneNumber = phoneNumber;
    }

    public PhoneBillPaymentTransaction(String telecomCompanyName, String phoneNumber, int amount) {
        super(amount, TransactionTypeEnum.PHONEBILLPAYMENT.getType(),
                TransactionTypeEnum.PHONEBILLPAYMENT.getDBalanceDirection());
        this.telecomCompanyName = telecomCompanyName;
        this.phoneNumber = phoneNumber;
    }

    public PhoneBillPaymentTransaction() {
        super();
    }

    public String getTelecomCompanyName() {
        return telecomCompanyName;
    }

    public void setTelecomCompanyName(String telecomCompanyName) {
        this.telecomCompanyName = telecomCompanyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
