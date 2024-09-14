package com.kevin.emazon_transacciones.domain.usecase;

import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.domain.spi.feign.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.exception.ItemNotAvaibleException;
import com.kevin.emazon_transacciones.infraestucture.exception.NotFoundDateWithItemId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SupplyUseCaseTest {

    private SupplyUseCase supplyUseCase;
    private ISupplyPersistentPort supplyPersistentPort;
    private IStockConnectionPort stockConnectionPort;

    @BeforeEach
    void setUp() {
        supplyPersistentPort = Mockito.mock(ISupplyPersistentPort.class);
        stockConnectionPort = Mockito.mock(IStockConnectionPort.class);
        supplyUseCase = new SupplyUseCase(supplyPersistentPort, stockConnectionPort);
    }

    @Test
    void createSupply_ShouldCreateSupply_WhenItemExistsInStock() {
        // Arrange
        Supply supply = new Supply(1L, 1L,100L, new Date(), 1L, 10.0);
        when(stockConnectionPort.existById(supply.getItemId())).thenReturn(true);

        // Act
        supplyUseCase.createSupply(supply);

        // Assert
        verify(stockConnectionPort, times(1)).updateQuantityOfItem(supply.getItemId(), supply.getQuantity());
        verify(supplyPersistentPort, times(1)).createSupply(supply);
    }

    @Test
    void createSupply_ShouldThrowItemNotAvailableException_WhenItemDoesNotExistInStock() {
        // Arrange
        Supply supply = new Supply(1L, 1L,100L, new Date(), 1L, 10.0);
        when(stockConnectionPort.existById(supply.getItemId())).thenReturn(false);

        // Act & Assert
        ItemNotAvaibleException exception = assertThrows(ItemNotAvaibleException.class, () -> supplyUseCase.createSupply(supply));
        assertEquals(SupplyUseCase.ITEM_NOT_AVAIBLE_EXCEPTION_MESSAGE, exception.getMessage());
        verify(stockConnectionPort, never()).updateQuantityOfItem(anyLong(), anyLong());
        verify(supplyPersistentPort, never()).createSupply(any(Supply.class));
    }

    @Test
    void createSupply_ShouldSetActualDate_WhenSupplyDateIsNull() {
        // Arrange
        Supply supply = new Supply(1L, 1L,100L, null, 1L, 10.0);
        when(stockConnectionPort.existById(supply.getItemId())).thenReturn(true);

        // Act
        supplyUseCase.createSupply(supply);

        // Assert
        assertNotNull(supply.getSupplyDate());
        assertEquals(SupplyUseCase.ACTUAL_DATE, supply.getSupplyDate());
        verify(stockConnectionPort, times(1)).updateQuantityOfItem(supply.getItemId(), supply.getQuantity());
        verify(supplyPersistentPort, times(1)).createSupply(supply);
    }

    @Test
    void getNextSupplyDate_ShouldReturnDate_WhenDateExistsForItem() {
        // Arrange
        Long itemId = 1L;
        Date expectedDate = new Date();
        when(supplyPersistentPort.getNextSupplyDate(itemId)).thenReturn(Optional.of(expectedDate));

        // Act
        Date result = supplyUseCase.getNextSupplyDate(itemId);

        // Assert
        assertEquals(expectedDate, result);
        verify(supplyPersistentPort, times(1)).getNextSupplyDate(itemId);
    }

    @Test
    void getNextSupplyDate_ShouldThrowNotFoundDateWithItemId_WhenNoDateFound() {
        // Arrange
        Long itemId = 1L;
        when(supplyPersistentPort.getNextSupplyDate(itemId)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundDateWithItemId exception = assertThrows(NotFoundDateWithItemId.class, () -> supplyUseCase.getNextSupplyDate(itemId));
        assertEquals(SupplyUseCase.NOT_FOUND_DATE_WITH_ID_MESSAGE, exception.getMessage());
        verify(supplyPersistentPort, times(1)).getNextSupplyDate(itemId);
    }
}
