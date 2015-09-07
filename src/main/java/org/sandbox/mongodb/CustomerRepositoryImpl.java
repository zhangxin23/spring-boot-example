package org.sandbox.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-9-7
 */
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<Customer> getCustomerByLastName(String lastName) {
        Criteria criteria = Criteria.where("lastName").is(lastName);
        return template.find(Query.query(criteria), Customer.class);
    }
}
