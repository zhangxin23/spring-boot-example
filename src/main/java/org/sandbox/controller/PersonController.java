package org.sandbox.controller;

import org.sandbox.orm.Person;
import org.sandbox.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangxin on 15/8/27.
 */
@RestController
@RequestMapping(value = "persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object getPerson(int id) {
        return personService.select(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> setPerson(@RequestParam("name")String name,
                            @RequestParam("age")int age,
                            @RequestParam("country")String country) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setCountry(country);

        personService.insert(person);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set("location", "http://localhost:8080/persons/1");

        return new ResponseEntity<>("insert successfully", headers, HttpStatus.OK);
    }
}
