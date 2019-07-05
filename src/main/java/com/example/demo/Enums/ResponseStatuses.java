/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Enums;

/**
 *
 * @author musembi
 */
public enum ResponseStatuses {
     SUCCESS(200, "Ok"), //
    OTP_EXPIRED(1000, "OTP code has expired, please request a new OTP"), //
    INVALID_OTP(1001, "OTP code provided is invalid, please provide a valid OTP or request a new one"), //
    TOO_MANY_PASSWORD_RESET_ATTEMPTS(1002,"Account has been bloacked because of many password reset attempts, contact customer care"), //
    CUSTOMER_HAS_EXISTING_LOAN(1003, "Account has an existing loan, can't request another one"), //
    REQUESTED_LOAN_IS_GREATER_THAN_LOAN_LIMIT(1004, "Can't request loan of %s, which is more than you qualify for %s."), //
    LOAN_REQUEST_FAILED(1005, "Loan request failed at the bank level"), //
    WALLET_ACCOUNT_ALREADY_LINKED(1006, "The wallet msisdn %s is already linked"), //
    CHEQUE_BOOK_REQUEST_UNAVAILABLE(1007, "This service is temporarily out of service, please try again later"), //
    SENDER_BANK_ACCOUNT_NOT_FOUND(1008, "Sender bank account number was not found"), //
    RECEIPIENT_BANK_ACCOUNT_NOT_FOUND(1009, "Receiver bank account number was not found"), //
    TRANSACTION_FAILED(1010, "Transaction failed"), //
    CUSTOMER_ALREADY_JOINED_THAT_SACCO(1011,
            "You have already joined this sacco, please go to add account instead if you have another account with the sacco."), //

    NOT_FOUND(404, "Not Found"), //
    UNAUTHORIZED(401, "You are not authorized to access this resource"), //
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");//

    private final int error_code;
    private final String description;

    private ResponseStatuses(int code, String desc) {
        this.error_code = code;
        this.description = desc;
    }

    public int getCode() {
        return this.error_code;
    }

    public String getDescription() {
        return this.description;
    }
   
}
