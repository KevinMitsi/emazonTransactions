package com.kevin.emazon_transacciones.infraestucture.feign.service;

import com.kevin.emazon_transacciones.domain.model.UpdateItemQuantityRequest;
import com.kevin.emazon_transacciones.infraestucture.feign.ConfigurationFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "STOCK-API", url = "http://localhost:8082/api/v1/item/", configuration = ConfigurationFeign.class)
public interface StockFeignClient {

    @GetMapping("exist/{id}")
    boolean existItemById(@PathVariable Long id);

    @GetMapping("isEnough/{id}/{quantity}")
    boolean isEnoughInStock(@PathVariable Long id, @PathVariable Long quantity);
    @PostMapping("updateQuantity")
    void updateQuantityOfItem(@RequestBody UpdateItemQuantityRequest updateRequest);
    @GetMapping("price/{itemId}")
    Double getItemPriceByItemId(@PathVariable Long itemId);

}
