package org.sandbox.controller;

import org.sandbox.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zhangxin
 * Date:   15-9-10
 */
@RestController
@RequestMapping(value = "demo/security")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "security", method = RequestMethod.GET)
    public ResponseEntity<?> security() {
        String msg = securityService.secure();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @RequestMapping(value = "authorized", method = RequestMethod.GET)
    public ResponseEntity<?> auhtorized() {
        String msg = securityService.authorized();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @RequestMapping(value = "denied", method = RequestMethod.GET)
    public ResponseEntity<?> denied() {
        String msg = securityService.denied();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
