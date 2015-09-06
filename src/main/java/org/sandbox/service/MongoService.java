package org.sandbox.service;

import org.sandbox.mongodb.Customer;
import org.sandbox.mongodb.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-9-1
 */
@Service
public class MongoService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    public List<Customer> getCustomerByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public void insert(String firstName, String lastName) {
        repository.save(new Customer(firstName, lastName));
    }
}
