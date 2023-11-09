package com.eteration.simplebanking.controller;


// This class is a place holder you can change the complete implementation
public class TransactionStatus {
    private final String status;
    private final boolean success;

    private final String approvalCode;

    public TransactionStatus(String status, boolean success, String approvalCode) {
        this.status = status;
        this.success = success;
        this.approvalCode = approvalCode;
    }

    public String getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getApprovalCode() {
        return approvalCode;
    }
}
