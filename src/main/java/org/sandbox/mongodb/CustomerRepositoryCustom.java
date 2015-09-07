package org.sandbox.mongodb;

import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-9-7
 */
public interface CustomerRepositoryCustom {
    List<Customer> getCustomerByLastName(String lastName);
}
