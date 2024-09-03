package com.kevin.emazon_transacciones.infraestucture.repository;

import com.kevin.emazon_transacciones.infraestucture.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
