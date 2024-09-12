package com.kevin.emazon_transacciones.application.handler.impl;

import com.kevin.emazon_transacciones.application.handler.ISupplyHandler;
import com.kevin.emazon_transacciones.application.dto.SupplyDto;
import com.kevin.emazon_transacciones.application.mapper.ISupplyDtoMapper;
import com.kevin.emazon_transacciones.domain.api.ISupplyServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class SupplyHandlerImpl implements ISupplyHandler {
    private final ISupplyServicePort supplyServicePort;
    private final ISupplyDtoMapper supplyDtoMapper;

    @Override
    public void createSupply(SupplyDto supplyDto) {
        supplyServicePort.createSupply(supplyDtoMapper.supplyDtoToSupply(supplyDto));
    }

    @Override
    public Date getNextSupplyDateFromItemId(Long itemId) {
        return supplyServicePort.getNextSupplyDate(itemId);
    }
}
