package com.kevin.emazon_transacciones.domain.model.external;

import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import com.kevin.emazon_transacciones.domain.model.SaleItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SaleReport {
    private String id;

    private String user;

    private List<SaleItem> saleItems;

    private Date saleDate;
    private PaymentStatus paymentStatus;

    public SaleReport(String user, List<SaleItem> saleItems, PaymentStatus paymentStatus,Date saleDate) {
        this.user = user;
        this.saleItems = saleItems;
        this.paymentStatus = paymentStatus;
        this.saleDate = saleDate;
    }

    public SaleReport() {
        //for frameworks etc
    }
}
