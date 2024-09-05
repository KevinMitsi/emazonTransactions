package com.kevin.emazon_transacciones.domain.spi;

import com.kevin.emazon_transacciones.domain.model.Supply;

public interface ISupplyPersistentPort {
    void createSupply(Supply supply);
}
