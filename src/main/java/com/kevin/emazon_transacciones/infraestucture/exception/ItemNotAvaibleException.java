package com.kevin.emazon_transacciones.infraestucture.exception;

public class ItemNotAvaibleException extends RuntimeException{
    public ItemNotAvaibleException(String message) {
        super(message);
    }
}
