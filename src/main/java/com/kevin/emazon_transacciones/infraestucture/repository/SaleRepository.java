package com.kevin.emazon_transacciones.infraestucture.repository;

import com.kevin.emazon_transacciones.infraestucture.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}
