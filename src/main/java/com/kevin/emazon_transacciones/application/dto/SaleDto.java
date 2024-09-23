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

    private static final String ID_NULL_MESSAGE = "El id no puede ser null";
    private static final String ITEM_ID_NULL_MESSAGE = "El id del item no puede ser null";
    private static final String NULL_DATE_MESSAGE = "La fecha de venta no puede ser null";
    private static final String FUTURE_DATE_MESSAGE = "La fecha de compra no puede ser en el futuro";
    private static final String NULL_PRICE_MESSAGE = "El valor de venta no puede ser null";
    private static final String NEGATIVE_OR_ZERO_PRICE_MESSAGE = "El valor de venta debe ser positivo";
    private static final String NULL_STATUS_MESSAGE = "El estatus de venta no puede ser null";


    @NotNull(message = ID_NULL_MESSAGE)
    private Long userId;

    @NotNull(message = ITEM_ID_NULL_MESSAGE)
    private List<SaleItemDto> saleItemsDto;

    private Date saleDate;

    private PaymentStatus paymentStatus;

}
