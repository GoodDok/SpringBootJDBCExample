package com.gooddok.service;

import com.gooddok.dao.CustomerDAO;
import com.gooddok.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer getCustomerById(int customerId) {
        return customerDAO.findCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers(){
        return customerDAO.findAll();
    }

    @Override
    public synchronized boolean addCustomer(Customer customer){
        return customerDAO.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomerById(customerId);
    }

}
