package com.kevin.emazon_transacciones.infraestucture.controller.exceptionhandler;

import com.kevin.emazon_transacciones.application.dto.ExceptionResponseDto;
import com.kevin.emazon_transacciones.infraestucture.exception.FeignRequestException;
import com.kevin.emazon_transacciones.infraestucture.exception.FeignServerException;
import com.kevin.emazon_transacciones.infraestucture.exception.ItemNotAvaibleException;
import com.kevin.emazon_transacciones.infraestucture.exception.NotFoundDateWithItemId;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class HandlerInterceptor {

    public static final String FEIGN_SERVER_EXCEPTION_MESSAGE = "Ha ocurrido un error en el servidor del microservicio con el que se comunica: ";
    public static final String FEIGN_REQUEST_EXCEPTION_MESSAGE = "Ha ocurrido una exception dentro de la request que hizo al microservicio externo";
    public static final String FEIGN_EXCEPTION_MESSAGE = "FeignException: Ha ocurrido un error con la comunicación de microservicos";

    @ExceptionHandler(ItemNotAvaibleException.class)
    public ResponseEntity<ExceptionResponseDto> inCaseThrowingItemNotAvaible(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(e.getClass().toString(), e.getMessage(), HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(FeignServerException.class)
    public ResponseEntity<ExceptionResponseDto> inCaseThrowingFeignServer(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(FEIGN_SERVER_EXCEPTION_MESSAGE, e.getMessage(), HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(FeignRequestException.class)
    public ResponseEntity<ExceptionResponseDto> inCaseThrowingFeignRequest(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(FEIGN_REQUEST_EXCEPTION_MESSAGE, e.getMessage(), HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionResponseDto> handleFeignException(FeignException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponseDto(FEIGN_EXCEPTION_MESSAGE,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(NotFoundDateWithItemId.class)
    public ResponseEntity<ExceptionResponseDto> inCaseThrowingNotFoundWithItemId(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(e.getClass().getName(), e.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
