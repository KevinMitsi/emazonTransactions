package com.kevin.emazon_transacciones.infraestucture.mapper;

import com.kevin.emazon_transacciones.domain.model.Sale;
import com.kevin.emazon_transacciones.infraestucture.entity.SaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = ISaleItemEntityMapper.class)
public interface ISaleEntityMapper {
    @Mapping(source = "saleItems", target = "saleItemDetails")
    SaleEntity saleToSaleEntity(Sale sale);
}
