package com.kevin.emazon_transacciones.domain.spi.feign;

public interface IStockConnectionPort {
    boolean existById(Long id);

    void updateQuantityOfItem(Long idItem, Long amount);
}
