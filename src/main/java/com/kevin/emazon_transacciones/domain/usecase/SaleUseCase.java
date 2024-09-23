package com.kevin.emazon_transacciones.domain.usecase;

import com.kevin.emazon_transacciones.domain.api.ISaleServicePort;
import com.kevin.emazon_transacciones.domain.model.Sale;
import com.kevin.emazon_transacciones.domain.model.SaleItem;
import com.kevin.emazon_transacciones.domain.spi.ISalePersistentPort;
import com.kevin.emazon_transacciones.domain.spi.external.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.exception.NotEnoughQuantityInStock;

import java.util.List;

public class SaleUseCase implements ISaleServicePort {
    public static final String NOT_ENOUGH_STOCK_QUANTITY_MESSAGE = "No hay suficiente stock para comprar el item: ";
    private final ISalePersistentPort salePersistentPort;
    private final IStockConnectionPort stockConnectionPort;

    public SaleUseCase(ISalePersistentPort salePersistentPort, IStockConnectionPort stockConnectionPort) {
        this.salePersistentPort = salePersistentPort;
        this.stockConnectionPort = stockConnectionPort;
    }

    @Override
    public void createSale(Sale sale) {
        validateIfItemsHaveStock(sale.getSaleItems());
        getItemsUnitPrice(sale.getSaleItems());
        salePersistentPort.createSale(sale);
    }


    private void validateIfItemsHaveStock(List<SaleItem> saleItems) {
        saleItems.forEach(saleItem ->{
            if (!stockConnectionPort.isEnoughStock(saleItem.getItemId(), saleItem.getQuantity())){
                throw new NotEnoughQuantityInStock(NOT_ENOUGH_STOCK_QUANTITY_MESSAGE +saleItem.getId());
            }
        });
    }
    private void getItemsUnitPrice(List<SaleItem> saleItems) {
        saleItems.forEach(saleItem -> saleItem.setUnitPrice(stockConnectionPort.getPriceByItemId(saleItem.getItemId())));
    }
}
