package com.kevin.emazon_transacciones.application.handler;

import com.kevin.emazon_transacciones.application.dto.SaleDto;

public interface ISaleHandler {
    void createSale(SaleDto saleDto);
}
