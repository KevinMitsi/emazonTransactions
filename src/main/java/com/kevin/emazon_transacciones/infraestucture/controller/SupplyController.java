package com.kevin.emazon_transacciones.infraestucture.controller;

import com.kevin.emazon_transacciones.application.handler.ISupplyHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/supply")
public class SupplyController {
    private static final String ROLE_AUX_BODEGA = "ROLE_AUX_BODEGA";
    private static final String CREATE_SUPPLY_MESSAGE = "Ha accedido al método createNewSupply";
    private final ISupplyHandler supplyHandler;

    @GetMapping("/new")
    @Secured(ROLE_AUX_BODEGA)
    public ResponseEntity<String> createNewSupply(){
        return ResponseEntity.status(200).body(CREATE_SUPPLY_MESSAGE);
    }
}
