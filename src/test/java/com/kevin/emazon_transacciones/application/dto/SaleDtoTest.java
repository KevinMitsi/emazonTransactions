package com.kevin.emazon_transacciones.application.dto;
import com.kevin.emazon_transacciones.domain.model.PaymentStatus;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
 class SaleDtoTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidSaleDto() {
        SaleDto saleDto = new SaleDto(1L, 2L, new Date(), 100.0, PaymentStatus.STATUS_PAID);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertTrue(violations.isEmpty(), "Valid SaleDto should have no violations");
    }

    @Test
    void testNullUserId() {
        SaleDto saleDto = new SaleDto(null, 2L, new Date(), 100.0, PaymentStatus.STATUS_PAID);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertFalse(violations.isEmpty());
        assertEquals("El id no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testNullItemId() {
        SaleDto saleDto = new SaleDto(1L, null, new Date(), 100.0, PaymentStatus.STATUS_PAID);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertFalse(violations.isEmpty());
        assertEquals("El id del item no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testNullSaleDate() {
        SaleDto saleDto = new SaleDto(1L, 2L, null, 100.0, PaymentStatus.STATUS_PAID);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertFalse(violations.isEmpty());
        assertEquals("La fecha de venta no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testFutureSaleDate() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // Tomorrow's date
        SaleDto saleDto = new SaleDto(1L, 2L, futureDate, 100.0, PaymentStatus.STATUS_PAID);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertFalse(violations.isEmpty());
        assertEquals("La fecha de compra no puede ser en el futuro", violations.iterator().next().getMessage());
    }

    @Test
    void testNullPrice() {
        SaleDto saleDto = new SaleDto(1L, 2L, new Date(), null, PaymentStatus.STATUS_PAID);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertFalse(violations.isEmpty());
        assertEquals("El valor de venta no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testNegativeOrZeroPrice() {
        SaleDto saleDto = new SaleDto(1L, 2L, new Date(), -100.0, PaymentStatus.STATUS_PAID);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertFalse(violations.isEmpty());
        assertEquals("El valor de venta debe ser positivo", violations.iterator().next().getMessage());
    }

    @Test
    void testNullPaymentStatus() {
        SaleDto saleDto = new SaleDto(1L, 2L, new Date(), 100.0, null);
        Set<ConstraintViolation<SaleDto>> violations = validator.validate(saleDto);
        assertFalse(violations.isEmpty());
        assertEquals("El estatus de venta no puede ser null", violations.iterator().next().getMessage());
    }
}
