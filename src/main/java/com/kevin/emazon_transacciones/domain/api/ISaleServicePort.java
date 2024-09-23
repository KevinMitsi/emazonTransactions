package com.kevin.emazon_transacciones.domain.api;

import com.kevin.emazon_transacciones.domain.model.Sale;

public interface ISaleServicePort {
    void createSale(Sale sale);
}
