package com.kevin.emazon_transacciones.infraestucture.adapter;

import com.kevin.emazon_transacciones.domain.spi.ISecurityContextPort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextAdapter implements ISecurityContextPort {


    @Override
    public Long userId() {
        return (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

    @Override
    public String userEmail() {
        return (String)SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
}
