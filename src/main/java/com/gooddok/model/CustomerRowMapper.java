package com.gooddok.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet row, int rowNum) throws SQLException {
        int id = row.getInt("id");
        String name = row.getString("name");
        String email = row.getString("email");
        Date createDate = row.getDate("created_date");
        return new Customer(id, name, email, createDate);
    }
}
