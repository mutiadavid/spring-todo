/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.responses;

import com.example.demo.Enums.ResponseStatuses;

/**
 *
 * @author root
 */
public class ResponseClass {
    private boolean success;
    private String message;
    private int statusCode;
    private String statusDescription;
    private Object responseData;  

    public ResponseClass() {
	this.success = true;
	this.statusCode = ResponseStatuses.SUCCESS.getCode();//your statuscode here
	this.statusDescription = ResponseStatuses.SUCCESS.getDescription();//your description here
    }

    public ResponseClass(boolean success, String message, int statusCode, String statusDescription, Object responseData) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.responseData = responseData;
    }
    public ResponseClass setInternalServerError(Exception e) {
        this.success = false;
        this.statusCode = ResponseStatuses.INTERNAL_SERVER_ERROR.getCode();
        this.statusDescription = String.format("%s, %s", ResponseStatuses.INTERNAL_SERVER_ERROR.getDescription(),
                e.getMessage());
        return this;
    }

    public ResponseClass setNotFoundError(String id, String name) {
        this.success = false;
        this.statusCode = ResponseStatuses.NOT_FOUND.getCode();
        this.statusDescription = String.format("%s %s, %s", name, id, ResponseStatuses.NOT_FOUND.getDescription());
        return this;
    }

    public ResponseClass setNotFoundError(long id, String name) {
        this.success = false;
        this.statusCode = ResponseStatuses.NOT_FOUND.getCode();
        this.statusDescription = String.format("%s %d, %s", name, id, ResponseStatuses.NOT_FOUND.getDescription());
        return this;
    }

    public ResponseClass setUnAuthorizedError() {
        this.success = false;
        this.statusCode = ResponseStatuses.UNAUTHORIZED.getCode();
        this.statusDescription = ResponseStatuses.UNAUTHORIZED.getDescription();
        return this;
    }
    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the statusDescription
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * @param statusDescription the statusDescription to set
     */
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    /**
     * @return the responseData
     */
    public Object getResponseData() {
        return responseData;
    }

    /**
     * @param responseData the responseData to set
     */
    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
    
}
