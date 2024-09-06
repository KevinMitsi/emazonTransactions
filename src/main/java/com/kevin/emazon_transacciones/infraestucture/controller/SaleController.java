package com.kevin.emazon_transacciones.infraestucture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sale")
public class SaleController {

    private static final String ROLE_CLIENT = "ROLE_CLIENTE";
    private static final String ROLE_ADMINISTRATOR = "ROLE_ADMINISTRADOR";

    @Secured({ROLE_CLIENT, ROLE_ADMINISTRATOR})
    @GetMapping("/buy")
    public ResponseEntity<String> buy(){
        return ResponseEntity.status(200).body("Felicidades ha accedido al end-point de comprar");
    }
}
