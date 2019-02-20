package com.demo.demosprjdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Integer test() {
        return jdbcTemplate.queryForObject("select 1", Integer.class);
    }
}
