package com.kevin.emazon_transacciones.infraestucture.config;

import com.kevin.emazon_transacciones.domain.api.ISupplyServicePort;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.domain.usecase.SupplyUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDeclarationClass {
    @Bean
    ISupplyServicePort getSupplServicePort(ISupplyPersistentPort supplyPersistentPort){
        return new SupplyUseCase(supplyPersistentPort);
    }
}
