package com.kevin.emazon_transacciones.infraestucture.adapter;

import com.kevin.emazon_transacciones.domain.model.Sale;
import com.kevin.emazon_transacciones.domain.spi.ISalePersistentPort;
import com.kevin.emazon_transacciones.infraestucture.entity.SaleEntity;
import com.kevin.emazon_transacciones.infraestucture.entity.SaleItemEntity;
import com.kevin.emazon_transacciones.infraestucture.mapper.ISaleEntityMapper;
import com.kevin.emazon_transacciones.infraestucture.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@RequiredArgsConstructor
public class JpaSaleAdapter implements ISalePersistentPort {
    private final SaleRepository saleRepository;
    private final ISaleEntityMapper saleEntityMapper;
    @Override
    @Transactional
    public void createSale(Sale sale) {
        SaleEntity saleEntity = saleEntityMapper.saleToSaleEntity(sale);
        saleRepository.save(createEntityBinding(saleEntity));
    }

    private SaleEntity createEntityBinding(SaleEntity saleEntity) {
        for (SaleItemEntity saleItem: saleEntity.getSaleItemDetails()){
            saleItem.setSale(saleEntity);
            saleItem.calculatePartialPrice();
        }
        saleEntity.calculateTotalPrice();
        return  saleEntity;
    }
}
