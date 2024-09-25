package com.kevin.emazon_transacciones.application.handler;

import com.kevin.emazon_transacciones.application.dto.SaleRequest;

public interface ISaleHandler {
    void createSale(SaleRequest saleDto);
}
