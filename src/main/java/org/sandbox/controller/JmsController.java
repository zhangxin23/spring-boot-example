package org.sandbox.controller;

import org.sandbox.service.JmsProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zhangxin
 * Date:   15-9-7
 */
@RestController
@RequestMapping(value = "demo/jms")
public class JmsController {

    @Autowired
    private JmsProducerService jmsProducerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> sendMsg(@RequestParam("msg")String msg) {
        jmsProducerService.sendMsg(msg);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
