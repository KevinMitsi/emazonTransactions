package com.kevin.emazon_transacciones.application.mapper;

import com.kevin.emazon_transacciones.application.dto.SaleItemDto;
import com.kevin.emazon_transacciones.domain.model.SaleItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISaleItemDtoMapper {
    SaleItem saleItemDtoToSaleItem(SaleItemDto saleItemDto);
}
