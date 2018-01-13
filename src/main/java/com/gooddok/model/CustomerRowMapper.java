package com.gooddok.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet row, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(row.getInt("id"));
        customer.setName(row.getString("name"));
        customer.setEmail(row.getString("email"));
        customer.setDate(row.getDate("created_date"));
        return customer;
    }
}
