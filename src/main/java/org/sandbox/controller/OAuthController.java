package org.sandbox.controller;

import org.sandbox.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zhangxin
 * Date:   15-9-12
 */
@RestController
@RequestMapping(value = "demo/oauth2")
public class OAuthController {

    @Autowired
    private OAuthService oAuthService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getOAuth() {
        String msg = oAuthService.getOAuth();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
