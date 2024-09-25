package com.kevin.emazon_transacciones.application.handler.impl;

import com.kevin.emazon_transacciones.application.dto.SaleRequest;
import com.kevin.emazon_transacciones.application.handler.ISaleHandler;
import com.kevin.emazon_transacciones.application.mapper.ISaleDtoMapper;
import com.kevin.emazon_transacciones.domain.api.ISaleServicePort;
import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class SaleHandlerImpl implements ISaleHandler {
    public static final Date ACTUAL_DATE = Date.from(Instant.now());
    private final ISaleServicePort saleServicePort;
    private final ISaleDtoMapper saleDtoMapper;
    @Override
    public void createSale(SaleRequest saleDto) {
        saleDto.setSaleDate(ACTUAL_DATE);
        saleDto.setPaymentStatus(PaymentStatus.STATUS_PAID);
        saleServicePort.createSale(saleDtoMapper.saleDtoToSale(saleDto));
    }
}
