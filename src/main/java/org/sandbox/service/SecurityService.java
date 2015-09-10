package org.sandbox.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Author: zhangxin
 * Date:   15-9-10
 */
@Service
public class SecurityService {

    @Secured("ROLE_USER")
    public String secure() {
        return "Hello Security";
    }

    @PreAuthorize("true")
    public String authorized() {
        return "Hello world";
    }

    @PreAuthorize("false")
    public String denied() {
        return "Denied";
    }
}
