package org.sandbox.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zhangxin
 * Date:   15-12-2
 */
@RestController
@RequestMapping(value = "profile")
public class ProfilesController {

    @Value("${name}")
    private String name;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object getName() {
        return name;
    }
}
