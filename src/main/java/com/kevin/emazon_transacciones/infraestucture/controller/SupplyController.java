package com.kevin.emazon_transacciones.infraestucture.controller;

import com.kevin.emazon_transacciones.application.dto.SupplyDto;
import com.kevin.emazon_transacciones.application.handler.ISupplyHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Setter
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/supply")
public class SupplyController {
    private static final String ROLE_AUX_BODEGA = "ROLE_AUX_BODEGA";
    private static final String CREATE_SUPPLY_MESSAGE = "Ha creado exitosamente un nuevo Supply en su aplicación al item:";
    private final ISupplyHandler supplyHandler;


    @PostMapping("/new")
    @Secured(ROLE_AUX_BODEGA)
    public ResponseEntity<String> createNewSupply(@Valid @RequestBody SupplyDto supplyDto){
        supplyDto.setWareHouseWorkerId((Long) SecurityContextHolder.getContext().getAuthentication().getDetails());
        supplyHandler.createSupply(supplyDto);
        return ResponseEntity.status(200).body(CREATE_SUPPLY_MESSAGE + supplyDto.getItemId());
    }
    @GetMapping("supplyDate/{id}")
    public Date getSupplyItemDate(@PathVariable Long id){
        return null;
    }
}
