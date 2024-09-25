package com.kevin.emazon_transacciones.application.mapper;

import com.kevin.emazon_transacciones.application.dto.SaleRequest;
import com.kevin.emazon_transacciones.domain.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = ISaleItemDtoMapper.class)
public interface ISaleDtoMapper {
    @Mapping(source = "saleItemsDto", target = "saleItems")
    Sale saleDtoToSale(SaleRequest saleDto);
}
