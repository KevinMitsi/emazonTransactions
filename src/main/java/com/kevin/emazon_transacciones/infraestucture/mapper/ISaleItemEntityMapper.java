package com.kevin.emazon_transacciones.infraestucture.mapper;

import com.kevin.emazon_transacciones.domain.model.Sale;
import com.kevin.emazon_transacciones.infraestucture.entity.SaleItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISaleItemEntityMapper {
    SaleItemEntity saleItemToSaleItemEntity(Sale sale);
}
