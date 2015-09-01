package org.sandbox.controller;

import org.sandbox.mongodb.Customer;
import org.sandbox.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: zhangxin
 * Date:   15-9-1
 */
@RestController
@RequestMapping(value = "/demo/mongo")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @RequestMapping(value = "customers/{firstName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getCustomersByFirstName(@PathVariable("firstName")String firstName) {
        Customer customer = mongoService.getCustomerByFirstName(firstName);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
