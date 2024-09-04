package com.kevin.emazon_transacciones.application.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SupplyDto {

    private static final String NULL_ITEM_ID_MESSAGE = "El Id del Item no puede ser null";
    private static final String NEGATIVE_ITEM_ID_MESSAGE = "No existen id's negativos";
    private static final String NULL_QUANTITY_MESSAGE = "El campo quantity no puede ser null";
    private static final String NEGATIVE_QUANTITY_MESSAGE = "El valor del campo quantity debe ser positivo";
    private static final String NULL_DATE_MESSAGE = "El campo supplyDate no puede ser null";
    private static final String BAD_DATE_MESSAGE = "La fecha de suministro (supplyDate) debe ser en el pasado o presente";
    private static final String NULL_WH_ID_MESSAGE = "El campo wareHouseWorkerId no puede ser null";
    private static final String NEGATIVE_WH_ID_MESSAGE = "El valor del campo wareHouseWorkerId debe ser positivo";
    private static final String NULL_PRICE_MESSAGE = "El campo price no puede ser null";
    private static final String NEGATIVE_PRICE_MESSAGE = "El valor del campo price debe ser positivo";

    @NotNull(message = NULL_ITEM_ID_MESSAGE)
    @Positive(message = NEGATIVE_ITEM_ID_MESSAGE)
    private Long itemId;

    @NotNull(message = NULL_QUANTITY_MESSAGE)
    @Positive(message = NEGATIVE_QUANTITY_MESSAGE)
    private Long quantity;

    @NotNull(message = NULL_DATE_MESSAGE)
    @PastOrPresent(message = BAD_DATE_MESSAGE)
    private Date supplyDate;

    @NotNull(message = NULL_WH_ID_MESSAGE)
    @Positive(message = NEGATIVE_WH_ID_MESSAGE)
    private Long wareHouseWorkerId;

    @NotNull(message = NULL_PRICE_MESSAGE)
    @Positive(message = NEGATIVE_PRICE_MESSAGE)
    private Double price;


}
