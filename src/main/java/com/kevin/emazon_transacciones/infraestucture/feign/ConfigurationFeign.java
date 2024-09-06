package com.kevin.emazon_transacciones.infraestucture.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFeign {
    @Bean
    Logger.Level feignLoggerLevel() {return Logger.Level.FULL;}
}
