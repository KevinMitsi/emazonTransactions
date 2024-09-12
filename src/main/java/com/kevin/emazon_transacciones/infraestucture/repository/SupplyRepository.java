package com.kevin.emazon_transacciones.infraestucture.repository;

import com.kevin.emazon_transacciones.infraestucture.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {
    @Query("SELECT s.supplyDate FROM SupplyEntity s WHERE  s.itemId = :itemId")
    Optional<Date> getSupplyDateWithItemId(Long itemId);
}
