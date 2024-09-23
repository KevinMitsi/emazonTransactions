package com.kevin.emazon_transacciones.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemDto {
    @NotNull
    private Long itemId;
    @NotNull
    @Positive
    private Long quantity;
}
