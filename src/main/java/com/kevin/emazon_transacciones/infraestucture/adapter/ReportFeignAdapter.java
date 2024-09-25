package com.kevin.emazon_transacciones.infraestucture.adapter;


import com.kevin.emazon_transacciones.domain.model.external.SaleReport;
import com.kevin.emazon_transacciones.domain.spi.external.IReportConnectionPort;
import com.kevin.emazon_transacciones.infraestucture.feign.service.ReportFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportFeignAdapter implements IReportConnectionPort {
    private final ReportFeignClient reportFeignClient;
    @Override
    public void saveSaleReport(SaleReport sale) {
        reportFeignClient.addSaleToReports(sale);
    }


}
