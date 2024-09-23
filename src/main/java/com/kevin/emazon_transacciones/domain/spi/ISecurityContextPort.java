package com.kevin.emazon_transacciones.domain.spi;

public interface ISecurityContextPort {
    Long userId();

    String userEmail();
}
