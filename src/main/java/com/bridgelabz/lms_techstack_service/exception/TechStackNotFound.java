package com.bridgelabz.lms_techstack_service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class TechStackNotFound extends RuntimeException {
    private long errorCode;
    private String statusMessage;
    public TechStackNotFound (long errorCode,String statusMessage){

        super(statusMessage);
        this.errorCode=errorCode;
        this.statusMessage=statusMessage;
    }
}
