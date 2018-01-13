package com.gooddok.dao;

import com.gooddok.model.Customer;
import com.gooddok.model.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all customers, thanks Java 8, you can create a custom RowMapper like this :
    public List<Customer> findAll() {
        RowMapper<Customer> rowMapper = new CustomerRowMapper();
        return jdbcTemplate.query("SELECT id, name, email, created_date FROM customer", rowMapper);
    }

    // Add new customer
    @Transactional
    public void addCustomer(String name, String email) {
        jdbcTemplate.update("INSERT INTO customer(name, email, created_date) VALUES (?,?,?)",
                name, email, new Date());
    }


}