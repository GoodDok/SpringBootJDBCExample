package com.gooddok.service;

import com.gooddok.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    boolean addCustomer(Customer customer);

    void deleteCustomer(int customerId);
}
