package com.kevin.emazon_transacciones.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Sale {
    private Long id;

    private Long userId;

    private List<SaleItem> saleItems;

    private Date saleDate;

    private Long partialPrice;

    private PaymentStatus paymentStatus;


    public Sale() {
        //For frameworks etc
    }

    public Sale(Long id, Long userId, List<SaleItem> saleItems, Date saleDate, PaymentStatus paymentStatus) {
        this.id = id;
        this.userId = userId;
        this.saleItems = saleItems;
        this.saleDate = saleDate;
        this.paymentStatus = paymentStatus;
    }
}
