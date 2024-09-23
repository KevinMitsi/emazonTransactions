package com.kevin.emazon_transacciones.infraestucture.exception;

public class NotEnoughQuantityInStock extends RuntimeException{
    public NotEnoughQuantityInStock(String message) {
        super(message);
    }
}
