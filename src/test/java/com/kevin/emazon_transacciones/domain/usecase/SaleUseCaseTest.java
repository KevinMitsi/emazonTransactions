package com.kevin.emazon_transacciones.domain.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.kevin.emazon_transacciones.domain.model.Sale;
import com.kevin.emazon_transacciones.domain.model.SaleItem;
import com.kevin.emazon_transacciones.domain.spi.ISalePersistentPort;
import com.kevin.emazon_transacciones.domain.spi.ISecurityContextPort;
import com.kevin.emazon_transacciones.domain.spi.external.IReportConnectionPort;
import com.kevin.emazon_transacciones.domain.spi.external.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.exception.NotEnoughQuantityInStock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaleUseCaseTest {

    @Mock
    private ISalePersistentPort salePersistentPort;

    @Mock
    private IStockConnectionPort stockConnectionPort;

    @Mock
    private ISecurityContextPort securityContextPort;

    @Mock
    private IReportConnectionPort reportConnectionPort;

    @InjectMocks
    private SaleUseCase saleUseCase;


    @Test
    void createSale_successful() {
        // Arrange
        Sale sale = new Sale();
        SaleItem saleItem = new SaleItem(1L, sale,5L, 5L,100.0);
        sale.setSaleItems(Collections.singletonList(saleItem));

        when(securityContextPort.userId()).thenReturn(1L);
        when(stockConnectionPort.isEnoughStock(5L, 5L)).thenReturn(true);
        when(stockConnectionPort.getPriceByItemId(5L)).thenReturn(100.0);

        // Act
        saleUseCase.createSale(sale);

        // Assert
        verify(salePersistentPort, times(1)).createSale(sale);
        verify(reportConnectionPort, times(1)).saveSaleReport(any());
    }

    @Test
    void createSale_notEnoughStock_throwsException() {
        // Arrange
        Sale sale = new Sale();
        SaleItem saleItem = new SaleItem(1L,sale, 5L, 3L,100.0);
        sale.setSaleItems(Collections.singletonList(saleItem));

        when(securityContextPort.userId()).thenReturn(1L);
        when(stockConnectionPort.isEnoughStock(5L, 3L)).thenReturn(false);

        // Act & Assert
        NotEnoughQuantityInStock exception = assertThrows(NotEnoughQuantityInStock.class, () -> saleUseCase.createSale(sale));

        assertEquals(SaleUseCase.NOT_ENOUGH_STOCK_QUANTITY_MESSAGE + saleItem.getId(), exception.getMessage());
        verify(salePersistentPort, never()).createSale(any());
        verify(reportConnectionPort, never()).saveSaleReport(any());
    }

    @Test
    void getItemsUnitPrice_setsCorrectPrices() {
        // Arrange
        Sale sale = new Sale();
        SaleItem saleItem1 = new SaleItem(1L, sale,1L, 1L,100.0);
        SaleItem saleItem2 = new SaleItem(2L, sale,9L,1L, 200.0);
        List<SaleItem> saleItems = Arrays.asList(saleItem1, saleItem2);
        sale.setSaleItems(saleItems);

        when(stockConnectionPort.getPriceByItemId(1L)).thenReturn(100.0);
        when(stockConnectionPort.getPriceByItemId(9L)).thenReturn(200.0);
        when(stockConnectionPort.isEnoughStock(1L, 1L)).thenReturn(true);
        when(stockConnectionPort.isEnoughStock(9L, 1L)).thenReturn(true);
        // Act
        saleUseCase.createSale(sale);

        // Assert
        assertEquals(100.0, saleItem1.getUnitPrice());
        assertEquals(200.0, saleItem2.getUnitPrice());
    }
}
