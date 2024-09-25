package com.kevin.emazon_transacciones.application.dto;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SupplyDtoTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidSupplyDto() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertTrue(violations.isEmpty(), "El SupplyDto debería ser válido");
    }

    @Test
    void testNullItemId() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(null);  // ItemId nulo
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "El itemId no debería ser nulo");
        assertEquals("El Id del Item no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testNegativeItemId() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(-1L);  // ItemId negativo
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "El itemId no debería ser negativo");
        assertEquals("No existen id's negativos", violations.iterator().next().getMessage());
    }

    @Test
    void testNullQuantity() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(null);  // Cantidad nula
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "La cantidad no debería ser nula");
        assertEquals("El campo quantity no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testNegativeQuantity() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(-100L);  // Cantidad negativa
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "La cantidad no debería ser negativa");
        assertEquals("El valor del campo quantity debe ser positivo", violations.iterator().next().getMessage());
    }

    @Test
    void testNullSupplyDate() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(null);  // Fecha de suministro nula
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "La fecha de suministro no debería ser nula");
        assertEquals("El campo supplyDate no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testFutureSupplyDate() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date(System.currentTimeMillis() + 86400000L));  // Fecha futura
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "La fecha de suministro no debería estar en el futuro");
        assertEquals("La fecha de suministro (supplyDate) debe ser en el pasado o presente", violations.iterator().next().getMessage());
    }

    @Test
    void testNullWareHouseWorkerId() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "El ID del trabajador no debería ser nulo");
        assertEquals("El campo wareHouseWorkerId no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testNegativeWareHouseWorkerId() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(1000.0);

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "El ID del trabajador no debería ser negativo");
        assertEquals("El valor del campo wareHouseWorkerId debe ser positivo", violations.iterator().next().getMessage());
    }

    @Test
    void testNullPrice() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(null);  // Precio nulo

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "El precio no debería ser nulo");
        assertEquals("El campo price no puede ser null", violations.iterator().next().getMessage());
    }

    @Test
    void testNegativePrice() {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setItemId(1L);
        supplyDto.setQuantity(100L);
        supplyDto.setSupplyDate(new Date());
        supplyDto.setPrice(-100.0);  // Precio negativo

        Set<ConstraintViolation<SupplyDto>> violations = validator.validate(supplyDto);
        assertFalse(violations.isEmpty(), "El precio no debería ser negativo");
        assertEquals("El valor del campo price debe ser positivo", violations.iterator().next().getMessage());
    }
}
