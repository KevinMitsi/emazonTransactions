package com.kevin.emazon_transacciones.domain.usecase;

import com.kevin.emazon_transacciones.domain.api.ISupplyServicePort;
import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;

public class SupplyUseCase implements ISupplyServicePort {
    private final ISupplyPersistentPort supplyPersistentPort;

    public SupplyUseCase(ISupplyPersistentPort supplyPersistentPort) {
        this.supplyPersistentPort = supplyPersistentPort;
    }

    @Override
    public void createSupply(Supply supply) {
        //logica
        supplyPersistentPort.createSupply(supply);
    }
}
