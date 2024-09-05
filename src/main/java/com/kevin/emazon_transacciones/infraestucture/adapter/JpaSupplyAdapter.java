package com.kevin.emazon_transacciones.infraestucture.adapter;

import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.infraestucture.mapper.ISupplyEntityMapper;
import com.kevin.emazon_transacciones.infraestucture.repository.SupplyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaSupplyAdapter implements ISupplyPersistentPort {
    private final SupplyRepository supplyRepository;
    private final ISupplyEntityMapper supplyEntityMapper;
    @Override
    public void createSupply(Supply supply) {
        supplyRepository.save(supplyEntityMapper.supplyToSupplyEntity(supply));
    }
}
