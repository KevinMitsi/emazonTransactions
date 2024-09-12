package com.kevin.emazon_transacciones.domain.spi;

import com.kevin.emazon_transacciones.domain.model.Supply;

import java.util.Date;
import java.util.Optional;

public interface ISupplyPersistentPort {
    void createSupply(Supply supply);
    Optional<Date> getNextSupplyDate(Long itemId);
}
