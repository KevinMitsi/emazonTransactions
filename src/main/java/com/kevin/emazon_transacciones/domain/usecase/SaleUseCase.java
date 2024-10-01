package com.kevin.emazon_transacciones.domain.usecase;

import com.kevin.emazon_transacciones.domain.api.ISaleServicePort;
import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import com.kevin.emazon_transacciones.domain.model.Sale;
import com.kevin.emazon_transacciones.domain.model.SaleItem;
import com.kevin.emazon_transacciones.domain.model.external.SaleReport;
import com.kevin.emazon_transacciones.domain.spi.ISalePersistentPort;
import com.kevin.emazon_transacciones.domain.spi.ISecurityContextPort;
import com.kevin.emazon_transacciones.domain.spi.external.IReportConnectionPort;
import com.kevin.emazon_transacciones.domain.spi.external.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.exception.NotEnoughQuantityInStock;
import com.kevin.emazon_transacciones.infraestucture.exception.SaleCreationException;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class SaleUseCase implements ISaleServicePort {
    public static final String NOT_ENOUGH_STOCK_QUANTITY_MESSAGE = "No hay suficiente stock para comprar el item: ";
    public static final String ERROR_IN_SALE_TRANSACTION_MESSAGE = "Ocurrió un error la transacción, será cancelada";
    public static final Date ACTUAL_DATE = Date.from(Instant.now());
    private final ISalePersistentPort salePersistentPort;
    private final IStockConnectionPort stockConnectionPort;
    private final ISecurityContextPort securityContextPort;
    private final IReportConnectionPort reportConnectionPort;

    public SaleUseCase(ISalePersistentPort salePersistentPort, IStockConnectionPort stockConnectionPort, ISecurityContextPort securityContextPort, IReportConnectionPort reportConnectionPort) {
        this.salePersistentPort = salePersistentPort;
        this.stockConnectionPort = stockConnectionPort;
        this.securityContextPort = securityContextPort;
        this.reportConnectionPort = reportConnectionPort;
    }

    @Override
    public void createSale(Sale sale) {
        sale.setUserId(securityContextPort.userId());
        validateIfItemsHaveStock(sale.getSaleItems());
        try {
            getItemsUnitPrice(sale.getSaleItems());
            sale.setPaymentStatus(PaymentStatus.STATUS_PAID);
            salePersistentPort.createSale(sale);
            createSaleReport(sale);
        }
        catch (Exception e){
            sale.setPaymentStatus(PaymentStatus.STATUS_CANCELLED);
            sale.setSaleDate(ACTUAL_DATE);
            createSaleReport(sale);
            throw new SaleCreationException(ERROR_IN_SALE_TRANSACTION_MESSAGE, sale);
        }
    }

    private void createSaleReport(Sale sale) {
        reportConnectionPort.saveSaleReport(new SaleReport(securityContextPort.userEmail(),sale.getSaleItems(),sale.getPaymentStatus(),sale.getSaleDate()));
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
