package com.kevin.emazon_transacciones.infraestucture.controller;

import com.kevin.emazon_transacciones.application.dto.SaleRequest;
import com.kevin.emazon_transacciones.application.handler.ISaleHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("api/v1/sale")
@RequiredArgsConstructor
public class SaleController {
    private static final String ROLE_CLIENT = "ROLE_CLIENTE";
    private final ISaleHandler saleHandler;

    @Secured(ROLE_CLIENT)
    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.OK)
    public void buy(@Valid @RequestBody SaleRequest saleDto){
        saleHandler.createSale(saleDto);
    }
}
