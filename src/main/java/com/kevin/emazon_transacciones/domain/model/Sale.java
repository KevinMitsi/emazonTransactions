package com.kevin.emazon_transacciones.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Sale {
    private Long id;

    private Long userId;

    private Long itemId;

    private Date saleDate;

    private Double price;

    private PaymentStatus paymentStatus;

    public Sale() {
        //For frameworks etc
    }

    public Sale(Long id, Long userId, Long itemId, Date saleDate, Double price, PaymentStatus paymentStatus) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.saleDate = saleDate;
        this.price = price;
        this.paymentStatus = paymentStatus;
    }
}
