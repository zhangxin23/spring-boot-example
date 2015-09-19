package org.sandbox.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangxin on 15/9/19.
 */
@RestController
@RequestMapping(value = "array")
public class ArrayParamsController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> testArrayParam(@RequestParam("params")String[] params) {

        for(int i = 0; i < params.length; i++) {
            System.out.println(params[i]);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
