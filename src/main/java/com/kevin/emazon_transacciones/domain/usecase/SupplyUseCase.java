package com.kevin.emazon_transacciones.domain.usecase;

import com.kevin.emazon_transacciones.domain.api.ISupplyServicePort;
import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.domain.spi.ISecurityContextPort;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.domain.spi.external.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.exception.ItemNotAvaibleException;
import com.kevin.emazon_transacciones.infraestucture.exception.NotFoundDateWithItemId;

import java.time.Instant;
import java.util.Date;

public class SupplyUseCase implements ISupplyServicePort {
    public static final String ITEM_NOT_AVAIBLE_EXCEPTION_MESSAGE = "El microservicio de stock responde: Este ID apunta a uno que no existe";
    public static final Date ACTUAL_DATE = Date.from(Instant.now());
    public static final String NOT_FOUND_DATE_WITH_ID_MESSAGE = "No se pudo encontrar ninguna fecha de suministro para este item";
    private final ISupplyPersistentPort supplyPersistentPort;
    private final IStockConnectionPort stockConnectionPort;
    private final ISecurityContextPort securityContextPort;

    public SupplyUseCase(ISupplyPersistentPort supplyPersistentPort, IStockConnectionPort stockConnectionPort, ISecurityContextPort securityContextPort) {
        this.supplyPersistentPort = supplyPersistentPort;
        this.stockConnectionPort = stockConnectionPort;
        this.securityContextPort = securityContextPort;
    }

    @Override
    public void createSupply(Supply supply) {
        supply.setWareHouseWorkerId(securityContextPort.userId());
        if (!stockConnectionPort.existById(supply.getItemId())){
            throw  new ItemNotAvaibleException(ITEM_NOT_AVAIBLE_EXCEPTION_MESSAGE);
        }
        if (supply.getSupplyDate()==null){
            supply.setSupplyDate(ACTUAL_DATE);
        }
        stockConnectionPort.updateQuantityOfItem(supply.getItemId(), supply.getQuantity());
        supplyPersistentPort.createSupply(supply);
    }

    @Override
    public Date getNextSupplyDate(Long itemId) {
        return supplyPersistentPort.getNextSupplyDate(itemId)
                .orElseThrow(() -> new NotFoundDateWithItemId(NOT_FOUND_DATE_WITH_ID_MESSAGE));
    }
}
