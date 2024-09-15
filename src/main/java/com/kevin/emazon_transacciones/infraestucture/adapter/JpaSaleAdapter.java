package com.kevin.emazon_transacciones.infraestucture.adapter;

import com.kevin.emazon_transacciones.domain.spi.ISalePersistentPort;
import org.springframework.transaction.annotation.Transactional;

public class JpaSaleAdapter implements ISalePersistentPort {
    @Override
    @Transactional
    public void buy() {
        //not yet
    }
}
