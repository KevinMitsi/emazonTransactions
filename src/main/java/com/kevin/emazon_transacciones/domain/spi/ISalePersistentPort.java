package com.kevin.emazon_transacciones.domain.spi;

import com.kevin.emazon_transacciones.domain.model.Sale;

public interface ISalePersistentPort {
    void createSale(Sale sale);
}
