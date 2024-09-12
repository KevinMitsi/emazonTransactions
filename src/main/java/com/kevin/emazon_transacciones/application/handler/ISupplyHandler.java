package com.kevin.emazon_transacciones.application.handler;

import com.kevin.emazon_transacciones.application.dto.SupplyDto;

import java.util.Date;

public interface ISupplyHandler {
    void createSupply(SupplyDto supplyDto);

    Date getNextSupplyDateFromItemId(Long itemId);
}
