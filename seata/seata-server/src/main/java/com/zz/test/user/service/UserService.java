package com.zz.test.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.test.user.dao.UserMapper;
import com.zz.test.user.entity.User;

import io.seata.spring.annotation.GlobalTransactional;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@GlobalTransactional
	public void update() {
        User user = new User();
        user.setId(5L);
        user.setName("5,修改过后"+System.currentTimeMillis());
        int i = userMapper.updateById(user);
        System.out.println(i);
//        if(1==1) {
//        	throw new RuntimeException("事务测试");
//        }
	}

}
