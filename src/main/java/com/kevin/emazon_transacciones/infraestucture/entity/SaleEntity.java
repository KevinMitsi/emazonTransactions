package com.kevin.emazon_transacciones.infraestucture.entity;

import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long itemId;

    private Date saleDate;

    private Double price;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
