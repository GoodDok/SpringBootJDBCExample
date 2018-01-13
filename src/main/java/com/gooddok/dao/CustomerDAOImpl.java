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
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Customer> rowMapper = new CustomerRowMapper();

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT id, name, email, created_date FROM customer", rowMapper);
    }

    @Override
    @Transactional
    public boolean addCustomer(Customer customer) {
        return jdbcTemplate.update("INSERT INTO customer(name, email, created_date) VALUES (?,?,?)",
                customer.getName(), customer.getEmail(), new Date()) == 1;
    }

    @Override
    @Transactional
    public boolean deleteCustomerById(int id) {
        return jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id) == 1;
    }

    @Override
    public Customer findCustomerById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, email, created_date FROM customer where id = ?", rowMapper, id);
    }


}