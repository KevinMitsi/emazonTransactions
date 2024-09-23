package com.kevin.emazon_transacciones.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleItem {
    private Long id;
    private Sale sale;
    private Long itemId;
    private Double unitPrice;
    private Long quantity;

    public SaleItem(Long id, Sale sale, Long itemId, Long quantity, Double unitPrice) {
        this.id = id;
        this.sale = sale;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public SaleItem() {
    }

}
