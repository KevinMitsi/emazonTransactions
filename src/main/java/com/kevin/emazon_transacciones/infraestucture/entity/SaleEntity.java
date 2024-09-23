package com.kevin.emazon_transacciones.infraestucture.entity;

import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "sale_item_id", nullable = false)
    private List<SaleItemEntity> saleItemDetails;

    @Column(nullable = false)
    private Date saleDate;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public void calculateTotalPrice(){
        Double price = 0d;
        for (SaleItemEntity saleItem : saleItemDetails){
            price+=saleItem.getUnitPrice();
        }
        setTotal(price);
    }
}
