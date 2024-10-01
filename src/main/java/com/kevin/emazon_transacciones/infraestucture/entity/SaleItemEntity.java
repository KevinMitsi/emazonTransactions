package com.kevin.emazon_transacciones.infraestucture.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SaleItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SaleEntity sale;
    
    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Double unitPrice;

     @Column(nullable = false)
    private Double partialPrice;

    public void calculatePartialPrice() {
        this.partialPrice = this.unitPrice*this.quantity;
    }
}
