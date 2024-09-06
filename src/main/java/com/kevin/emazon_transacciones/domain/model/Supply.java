package com.kevin.emazon_transacciones.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Supply {
    private Long id;

    private Long itemId;
    private Long quantity;
    private Date supplyDate;
    private Long wareHouseWorkerId;
    private Double price;

    public Supply() {
    }

    public Supply(Long id, Long itemId, Long quantity, Date supplyDate, Long wareHouseWorkerId, Double price) {
        this.id = id;
        this.itemId = itemId;
        this.quantity = quantity;
        this.supplyDate = supplyDate;
        this.wareHouseWorkerId = wareHouseWorkerId;
        this.price = price;
    }

}
