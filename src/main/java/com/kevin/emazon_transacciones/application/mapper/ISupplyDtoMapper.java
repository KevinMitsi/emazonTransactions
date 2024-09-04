package com.kevin.emazon_transacciones.application.mapper;

import com.kevin.emazon_transacciones.application.dto.SupplyDto;
import com.kevin.emazon_transacciones.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISupplyDtoMapper {

    Supply supplyDtoToSupply(SupplyDto supplyDto);
    SupplyDto supplyToSupplyDto(Supply supply);
}
