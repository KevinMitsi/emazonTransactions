package com.kevin.emazon_transacciones.infraestucture.exception;

import com.kevin.emazon_transacciones.domain.model.Sale;
import lombok.Getter;

@Getter
public class SaleCreationException extends RuntimeException {

    private final transient Sale sale;

    public SaleCreationException(String message, Sale sale) {
        super(message);
        this.sale = sale;
    }

}
