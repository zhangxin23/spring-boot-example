package org.sandbox.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-9-1
 */
public interface CustomerRepository extends MongoRepository<Customer, String>, CustomerRepositoryCustom {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}