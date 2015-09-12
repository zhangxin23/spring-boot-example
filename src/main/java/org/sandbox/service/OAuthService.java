package org.sandbox.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * Author: zhangxin
 * Date:   15-9-12
 */
@Service
public class OAuthService {

    @Secured("USER_ROLE")
    public String getOAuth() {
        return "Hello OAuth";
    }
}
