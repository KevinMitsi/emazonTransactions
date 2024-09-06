package com.kevin.emazon_transacciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmazonTransaccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmazonTransaccionesApplication.class, args);
	}

}
