package com.kevin.emazon_transacciones.domain.usecase;

import com.kevin.emazon_transacciones.domain.api.ISupplyServicePort;
import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.domain.spi.feign.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.exception.ItemNotAvaibleException;

import java.time.Instant;
import java.util.Date;

public class SupplyUseCase implements ISupplyServicePort {
    public static final String ITEM_NOT_AVAIBLE_EXCEPTION_MESSAGE = "El microservicio de stock responde: Este ID apunta a uno que no existe";
    private final ISupplyPersistentPort supplyPersistentPort;
    private final IStockConnectionPort stockConnectionPort;

    public SupplyUseCase(ISupplyPersistentPort supplyPersistentPort, IStockConnectionPort stockConnectionPort) {
        this.supplyPersistentPort = supplyPersistentPort;
        this.stockConnectionPort = stockConnectionPort;
    }

    @Override
    public void createSupply(Supply supply) {
        if (!stockConnectionPort.existById(supply.getItemId())){
            throw  new ItemNotAvaibleException(ITEM_NOT_AVAIBLE_EXCEPTION_MESSAGE);
        }
        if (supply.getSupplyDate()==null){
            supply.setSupplyDate(Date.from(Instant.now()));
        }
        stockConnectionPort.updateQuantityOfItem(supply.getItemId(), supply.getQuantity());
        supplyPersistentPort.createSupply(supply);
    }
}
