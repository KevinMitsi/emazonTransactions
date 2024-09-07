package com.kevin.emazon_transacciones.infraestucture.adapter;

import com.kevin.emazon_transacciones.domain.model.UpdateItemQuantityRequest;
import com.kevin.emazon_transacciones.domain.spi.feign.IStockConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.feign.service.StockFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockFeignAdapter implements IStockConnectionPort {

    private final StockFeignClient stockFeignClient;

    @Override
    public boolean existById(Long id) {
        return stockFeignClient.existItemById(id);
    }

    @Override
    public void updateQuantityOfItem(Long idItem, Long amount) {
        stockFeignClient.updateQuantityOfItem(new UpdateItemQuantityRequest(idItem, amount));
    }
}
