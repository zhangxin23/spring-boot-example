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
@RequestMapping(value = "/app/v1")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "persons/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object getPerson(@PathVariable int id) {
        return personService.select(id);
    }

    @RequestMapping(value = "persons", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> setPerson(@RequestParam("name")String name,
                            @RequestParam("age")int age,
                            @RequestParam("country")String country) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setCountry(country);

        int id = personService.insert(person);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set("location", "http://localhost:8080/persons/" + id);

        return new ResponseEntity<>("insert successfully", headers, HttpStatus.OK);
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestParam("name") String name,
                                               @RequestParam("age")int age,
                                               @RequestParam("country")String country) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        person.setCountry(country);

        personService.update(person);

        return new ResponseEntity<>("update successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delPerson(@PathVariable int id) {
        personService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
