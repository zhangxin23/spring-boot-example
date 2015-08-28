package org.sandbox.controller;

import org.sandbox.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zhangxin
 * Date:   15-8-28
 */
@RestController
@RequestMapping(value = "v1")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "redis", method = RequestMethod.GET)
    public ResponseEntity<String> getValue(@RequestParam("key")String key) {
        return new ResponseEntity<>(redisService.getValue(key), HttpStatus.OK);
    }

    @RequestMapping(value = "redis", method = RequestMethod.POST)
    public ResponseEntity<String> setValue(@RequestParam("key")String key, @RequestParam("value")String value) {
        redisService.setValue(key, value);
        return new ResponseEntity<>("set key/value successfully", HttpStatus.OK);
    }
}
