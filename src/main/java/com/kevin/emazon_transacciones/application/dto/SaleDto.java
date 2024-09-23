package com.kevin.emazon_transacciones.application.dto;

import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {

    private static final String ITEM_ID_NULL_MESSAGE = "El id del item no puede ser null";

    @NotNull(message = ITEM_ID_NULL_MESSAGE)
    private List<SaleItemDto> saleItemsDto;

    private Date saleDate;

    private PaymentStatus paymentStatus;

}
