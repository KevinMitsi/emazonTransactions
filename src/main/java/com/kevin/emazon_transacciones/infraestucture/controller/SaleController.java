package com.kevin.emazon_transacciones.infraestucture.controller;

import com.kevin.emazon_transacciones.application.dto.SaleDto;
import com.kevin.emazon_transacciones.application.handler.ISaleHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("api/v1/sale")
@RequiredArgsConstructor
public class SaleController {
    private static final String ROLE_CLIENT = "ROLE_CLIENTE";
    public static final String SUCCESSFUL_BUY_MESSAGE = "Felicidades ha comprado";
    private final ISaleHandler saleHandler;

    @Secured(ROLE_CLIENT)
    @PostMapping("/buy")
    public ResponseEntity<String> buy(@Valid @RequestBody SaleDto saleDto){
        saleHandler.createSale(saleDto);
        return ResponseEntity.ok().body(SUCCESSFUL_BUY_MESSAGE);
    }
}
