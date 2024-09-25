package com.kevin.emazon_transacciones.domain.spi.external;

import com.kevin.emazon_transacciones.domain.model.external.SaleReport;

public interface IReportConnectionPort {
    void saveSaleReport(SaleReport sale);
}
