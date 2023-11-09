package com.eteration.simplebanking.controller;

public enum ResponseStatusEnum {
    SUCCESS("OK", true, "Success"),
    FAIL("NOTOK", false, "Fail");
    private String status;

    private boolean success;
    private String description;

    ResponseStatusEnum(String status, boolean success, String description) {
        this.status = status;
        this.success = success;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDescription() {
        return description;
    }
}
