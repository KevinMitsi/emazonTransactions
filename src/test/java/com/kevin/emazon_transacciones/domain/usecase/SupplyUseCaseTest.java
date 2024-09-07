package com.kevin.emazon_transacciones.domain.usecase;

import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.domain.spi.feign.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.exception.ItemNotAvaibleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplyUseCaseTest {

    @Mock
    private ISupplyPersistentPort supplyPersistentPort;

    @Mock
    private IStockConnectionPort stockConnectionPort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;


    @Test
    void createSupply_ShouldThrowException_WhenItemDoesNotExist() {
        // Arrange
        Supply supply = new Supply();
        supply.setItemId(1L);
        when(stockConnectionPort.existById(1L)).thenReturn(false);

        // Act & Assert
        ItemNotAvaibleException exception = assertThrows(ItemNotAvaibleException.class, () -> {
            supplyUseCase.createSupply(supply);
        });

        assertEquals(SupplyUseCase.ITEM_NOT_AVAIBLE_EXCEPTION_MESSAGE, exception.getMessage());
        verify(stockConnectionPort, times(1)).existById(1L);
        verifyNoInteractions(supplyPersistentPort); // Ensure no supply is created
    }

    @Test
    void createSupply_ShouldSetCurrentDate_WhenSupplyDateIsNull() {
        // Arrange
        Supply supply = new Supply();
        supply.setItemId(1L);
        supply.setQuantity(10L);
        when(stockConnectionPort.existById(1L)).thenReturn(true);

        // Act
        supplyUseCase.createSupply(supply);

        // Assert
        assertNotNull(supply.getSupplyDate()); // Date should be set
        verify(stockConnectionPort, times(1)).updateQuantityOfItem(1L, 10L);
        verify(supplyPersistentPort, times(1)).createSupply(supply);
    }

    @Test
    void createSupply_ShouldCallUpdateQuantityAndCreateSupply_WhenItemExists() {
        // Arrange
        Supply supply = new Supply();
        supply.setItemId(1L);
        supply.setQuantity(5L);
        supply.setSupplyDate(new Date());

        when(stockConnectionPort.existById(1L)).thenReturn(true);

        // Act
        supplyUseCase.createSupply(supply);

        // Assert
        verify(stockConnectionPort, times(1)).existById(1L);
        verify(stockConnectionPort, times(1)).updateQuantityOfItem(1L, 5L);
        verify(supplyPersistentPort, times(1)).createSupply(supply);
    }
}
