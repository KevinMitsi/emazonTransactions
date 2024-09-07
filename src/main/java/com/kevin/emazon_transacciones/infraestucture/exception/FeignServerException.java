package com.kevin.emazon_transacciones.infraestucture.exception;

public class FeignServerException extends RuntimeException{
    public FeignServerException(String message) {
        super(message);
    }
}
