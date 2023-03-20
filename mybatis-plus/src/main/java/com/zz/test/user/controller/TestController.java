package com.zz.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.test.user.dao.UserMapper;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping(value = "/test1")
    public String list() {
		return userMapper.selectUserVo(1L).getName();
    }
}
