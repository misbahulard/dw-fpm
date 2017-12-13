package com.dw.dao.mysql;

import com.dw.model.mysql.Customer;

import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public interface CustomerDAO {
    public List<Customer> readCustomer();
}
