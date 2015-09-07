package org.sandbox.service;

import org.sandbox.mongodb.Customer;
import org.sandbox.mongodb.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public void delete(String id) {
        repository.delete(id);
    }

    public void update(String id, String firstName, String lastName) {
        Customer customer = repository.findOne(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        repository.save(customer);
    }
}
