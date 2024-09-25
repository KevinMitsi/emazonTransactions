package com.kevin.emazon_transacciones.domain.spi.external;

public interface IStockConnectionPort {
    boolean existById(Long id);

    void updateQuantityOfItem(Long idItem, Long amount);

    boolean isEnoughStock(Long itemId, Long quantity);

    Double getPriceByItemId(Long itemId);

}
