package com.nokia.springboot.training.d03.s02;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PreAuthorize("isFullyAuthenticated() AND hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public void addProduct() {

    }

    public void processInternalRequest(@RequestHeader(value = "SECURITY_TOKEN") final String securityToken) {
        if (securityToken.isEmpty()) {
            throw new AccessDeniedException("Nope");
        }
    }
}
