package org.sandbox.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.sandbox.exception.ErrorDetail;
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
@RequestMapping(value = "/demo/v1")
@Api(value = "person", description = "Spring Boot Example Persion Controller")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "persons/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Fetch API", notes = "Fetch person by id", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error", response = ErrorDetail.class)})
    public Object getPerson(@PathVariable int id) {
        return personService.select(id);
    }

    @RequestMapping(value = "persons", method = RequestMethod.POST)
    @ApiOperation(value = "POST API", notes = "Add new person by multiple params into database", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "add successfully", response = String.class),
                           @ApiResponse(code = 500, message = "server error", response = ErrorDetail.class)})
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

        return new ResponseEntity<>("ResponseEntity insert successfully", headers, HttpStatus.OK);
    }

    @RequestMapping(value = "personObject", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Set API", notes = "Add new person by person object into database", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "add successfully", response = String.class),
                           @ApiResponse(code = 500, message = "server error", response = ErrorDetail.class)})
    public Object setPersonObject(@RequestBody Person person) {
        personService.insert(person);
        return "insert successfully.";
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update API", notes = "Update person by id and multiply params", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "update successfully", response = String.class),
                           @ApiResponse(code = 500, message = "server error", response = ErrorDetail.class)})
    public ResponseEntity<String> updatePerson(@PathVariable("id") int id, @RequestParam("name") String name,
                                               @RequestParam("age") int age,
                                               @RequestParam("country") String country) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        person.setCountry(country);

        personService.update(person);

        return new ResponseEntity<>("update successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "personObject/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update API", notes = "Update person by id and person object params into database", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "add successfully", response = String.class),
                           @ApiResponse(code = 500, message = "server error", response = ErrorDetail.class)})
    public ResponseEntity<String> updatePersonObject(@PathVariable("id") int id, @RequestBody Person person) {
        person.setId(id);
        personService.update(person);

        return new ResponseEntity<>("update successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete API", notes = "Delete person by id", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "delete successfully", response = Void.class),
                           @ApiResponse(code = 500, message = "server error", response = ErrorDetail.class)})
    public ResponseEntity<?> delPerson(@PathVariable int id) {
        personService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
