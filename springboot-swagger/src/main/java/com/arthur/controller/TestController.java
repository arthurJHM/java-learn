package com.arthur.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: TestController
 * @Author ArthurJi
 * @Date: 2021/4/23 14:47
 * @Version 1.0
 */

@Api(tags = "TestController")
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("list")
    @ApiOperation("TESTSWAGGER")
    String listTest() {
        return "TESTSWAGGER";
    }
}
