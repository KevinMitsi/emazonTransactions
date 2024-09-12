package com.kevin.emazon_transacciones.domain.api;

import com.kevin.emazon_transacciones.domain.model.Supply;

import java.util.Date;

public interface ISupplyServicePort {
    void createSupply(Supply supply);

    Date getNextSupplyDate(Long itemId);
}
