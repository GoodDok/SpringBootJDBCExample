package com.gooddok.dao;

import com.gooddok.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();

    @Transactional
    boolean addCustomer(Customer customer);

    @Transactional
    boolean deleteCustomerById(int id);

    Customer findCustomerById(int id);
}
