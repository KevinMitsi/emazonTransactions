package com.kevin.emazon_transacciones.infraestucture.exception;

public class FeignRequestException extends RuntimeException{
    public FeignRequestException(String message) {
        super(message);
    }
}
