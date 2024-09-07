package com.kevin.emazon_transacciones.infraestucture.mapper;

import com.kevin.emazon_transacciones.domain.model.Supply;
import com.kevin.emazon_transacciones.infraestucture.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISupplyEntityMapper {
    Supply supplyEntityToSupply(SupplyEntity supplyEntity);
    SupplyEntity toSupplyEntity(Supply supply);
}
