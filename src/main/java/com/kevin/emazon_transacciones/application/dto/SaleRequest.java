package com.kevin.emazon_transacciones.application.dto;

import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import jakarta.validation.constraints.NotNull;
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
public class SaleRequest {

    private static final String ITEM_ID_NULL_MESSAGE = "El id del item no puede ser null";

    @NotNull(message = ITEM_ID_NULL_MESSAGE)
    private List<SaleItemDetails> saleItemsDto;

    private Date saleDate;

    private PaymentStatus paymentStatus;

}
