package com.kevin.emazon_transacciones.infraestucture.exception;

public class NotFoundDateWithItemId extends RuntimeException{
    public NotFoundDateWithItemId(String message) {
        super(message);
    }
}
