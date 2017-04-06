package com.nokia.springboot.training.d03.s02;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PreAuthorize(
            "isFullyAuthenticated() " +
                "AND " +
            "hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')"
    )
    @RequestMapping(
            path = "/product",
            method = RequestMethod.GET
    )
    public void getProduct(@AuthenticationPrincipal UserDetails userDetails) {
        final String currentUserName = userDetails.getUsername();
        System.out.println("The current user is '" + currentUserName + "'");
    }
}
