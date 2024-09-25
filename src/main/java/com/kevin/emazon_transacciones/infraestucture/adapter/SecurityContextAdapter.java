package com.kevin.emazon_transacciones.infraestucture.adapter;

import com.kevin.emazon_transacciones.domain.spi.ISecurityContextPort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextAdapter implements ISecurityContextPort {


    @Override
    public Long userId() {
        return (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

    @Override
    public String userEmail() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                Object principal = authentication.getPrincipal();

                if (principal instanceof UserDetails userDetails) {
                    return userDetails.getUsername();
                } else if (principal instanceof String string) {
                    return string;
                }
            }
            return null;
    }
}
