package com.kevin.emazon_transacciones.domain.model;

import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    public Long getWareHouseWorkerId() {
        return wareHouseWorkerId;
    }

    public void setWareHouseWorkerId(Long wareHouseWorkerId) {
        this.wareHouseWorkerId = wareHouseWorkerId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
