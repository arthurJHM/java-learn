package com.arthur.jdbcTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @title: jdbcTemplateTest
 * @Author ArthurJi
 * @Date: 2021/5/8 12:30
 * @Version 1.0
 */
public class jdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
