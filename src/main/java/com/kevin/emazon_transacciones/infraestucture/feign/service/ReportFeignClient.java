package com.kevin.emazon_transacciones.infraestucture.feign.service;


import com.kevin.emazon_transacciones.domain.model.external.SaleReport;
import com.kevin.emazon_transacciones.infraestucture.feign.ConfigurationFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "report-api", url = "http://localhost:8086/api/v1/report/", configuration = ConfigurationFeign.class)
public interface ReportFeignClient {
    @PostMapping("new/sale")
    void addSaleToReports(@RequestBody SaleReport sale);


}
