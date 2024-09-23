package com.kevin.emazon_transacciones.infraestucture.config;

import com.kevin.emazon_transacciones.domain.api.ISaleServicePort;
import com.kevin.emazon_transacciones.domain.api.ISupplyServicePort;
import com.kevin.emazon_transacciones.domain.spi.ISalePersistentPort;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.domain.spi.external.IStockConnectionPort;
import com.kevin.emazon_transacciones.domain.usecase.SaleUseCase;
import com.kevin.emazon_transacciones.domain.usecase.SupplyUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDeclarationClass {
    @Bean
    ISupplyServicePort getSupplServicePort(ISupplyPersistentPort supplyPersistentPort, IStockConnectionPort stockConnectionPort){
        return new SupplyUseCase(supplyPersistentPort, stockConnectionPort);
    }
    @Bean
    ISaleServicePort saleServicePort(ISalePersistentPort salePersistentPort, IStockConnectionPort stockConnectionPort){
        return new SaleUseCase(salePersistentPort, stockConnectionPort);
    }
}
