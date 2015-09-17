package org.sandbox.controller;

import org.sandbox.exception.CustomException;
import org.sandbox.exception.ValidateObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * Author: zhangxin
 * Date:   15-9-17
 */
@RestController
@RequestMapping(value = "demo/v1/")
public class ExampleExceptionController {

    @RequestMapping(value = "exceptions/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getException(@PathVariable("id")String id) {
        if(id.equals("0"))
            throw new CustomException("ha ha, got exception.");

        return new ResponseEntity<>("no exception.", null, HttpStatus.OK);
    }

    @RequestMapping(value = "exceptions/validate", method = RequestMethod.POST)
    public ResponseEntity<?> addValidObject(@Valid @RequestBody ValidateObject validateObject) {
        HttpHeaders headers = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(validateObject.getId()).toUri();
        headers.setLocation(newUri);

        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }
}
