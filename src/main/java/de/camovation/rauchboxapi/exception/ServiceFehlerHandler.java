package de.camovation.rauchboxapi.exception;

import lombok.Getter;

@Getter
public class ServiceFehlerHandler extends RuntimeException {
    
    private ErrorCode errorCode;

    public ServiceFehlerHandler(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

}
