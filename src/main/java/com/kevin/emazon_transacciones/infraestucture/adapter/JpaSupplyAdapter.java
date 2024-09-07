package com.kevin.emazon_transacciones.infraestucture.adapter;

import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.domain.spi.ISupplyPersistentPort;
import com.kevin.emazon_transacciones.infraestucture.entity.SupplyEntity;
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
        SupplyEntity supplyEntity = supplyEntityMapper.toSupplyEntity(supply);
        supplyRepository.save(supplyEntity);
    }
}
