package com.kevin.emazon_transacciones.infraestucture.feign.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "STOCK-API", url = "http://localhost:8081/api/v1/item")
public interface StockFeignClient {

}
