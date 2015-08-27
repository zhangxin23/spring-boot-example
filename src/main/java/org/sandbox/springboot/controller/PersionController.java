package org.sandbox.springboot.controller;

import org.sandbox.springboot.dao.PersionDao;
import org.sandbox.springboot.model.Persion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangxin on 15/8/27.
 */
@RestController
@RequestMapping(value = "persion")
public class PersionController {

    @RequestMapping(value = "name", method = RequestMethod.GET)
    @ResponseBody
    public String getPersionName(int id) {
        PersionDao persionDao = new PersionDao();
        Persion persion = persionDao.select(id);
        if(persion != null)
            return persion.getName();
        return "empty";
    }
}
