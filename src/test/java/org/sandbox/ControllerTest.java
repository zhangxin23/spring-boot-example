package org.sandbox;

import org.junit.Before;
import org.junit.Test;
import org.sandbox.orm.Person;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: zhangxin
 * Date:   15-9-2
 */
public class ControllerTest {
    private static final String PREFIX_URI = "http://localhost:8080/v1/";

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp() {
        HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        HttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        HttpMessageConverter jacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();

        restTemplate.setMessageConverters(Arrays.asList(new HttpMessageConverter[]{formHttpMessageConverter,
                                                                                   stringHttpMessageConverter,
                                                                                   jacksonHttpMessageConverter}));
    }

    @Test
    public void testGetPerson() {
        ResponseEntity<Person> responseEntity = restTemplate.getForEntity(PREFIX_URI + "persons/6", Person.class);
        Person person = responseEntity.getBody();
        System.out.println(person);
    }

    @Test
    public void testPostPerson() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "hahaha");
        params.add("age", "1");
        params.add("country", "china");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(PREFIX_URI + "persons", entity, String.class);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("headers: location=" + responseHeaders.get("location"));
        System.out.println("body: " + responseEntity.getBody());
    }

    @Test
    public void testPostPersonObject() {
        Person person = new Person();
        person.setName("rest");
        person.setAge(1);
        person.setCountry("China");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(PREFIX_URI + "personObject", person, String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void testPersonExchangePost() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "hello");
        params.add("age", "1");
        params.add("country", "china");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        restTemplate.exchange(PREFIX_URI + "persons", HttpMethod.POST, entity, String.class);
    }

    @Test
    public void testPersonExchangePut() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "hero");
        params.add("age", "1");
        params.add("country", "China");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        restTemplate.exchange(PREFIX_URI + "persons/39", HttpMethod.PUT, entity, String.class);
    }

    @Test
    public void testPersonDel() {
        restTemplate.delete(PREFIX_URI + "persons/{id}", 34);
    }

    @Test
    public void testPersonUpdate() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "superman");
        params.add("age", "30");
        params.add("country", "USA");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        restTemplate.put(PREFIX_URI + "persons/{id}", entity, 38);
    }

    @Test
    public void testPersonObjectUpdate() {
        Person person = new Person();
        person.setName("superman");
        person.setAge(30);
        person.setCountry("USA");

        restTemplate.put(PREFIX_URI + "personObject/{id}", person, 39);
    }
}
