package com.zz.test.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/test")
@Tag(name = "API", description = "API operations")
public class TestController {


	
	@GetMapping(value = "/test1")
	@Operation(summary = "Say hello", description = "Say hello to the world")
    public String list() {
		return "test1";
    }
}
