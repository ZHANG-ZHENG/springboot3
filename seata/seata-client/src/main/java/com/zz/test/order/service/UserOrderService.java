package com.zz.test.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.test.order.dao.UserOrderMapper;
import com.zz.test.order.entity.UserOrder;
import com.zz.test.server.feign.FeignServer;

import io.seata.spring.annotation.GlobalTransactional;


@Service
public class UserOrderService {

	@Autowired
	private FeignServer feignServer;
	
	@Autowired
	private UserOrderMapper userOrderMapper;
	
	@GlobalTransactional
	public void update() {
		UserOrder userOrder = new UserOrder();
		userOrder.setId(1L);
		userOrder.setOrderNumber("修改过后"+System.currentTimeMillis());
        int i = userOrderMapper.updateById(userOrder);
        System.out.println(i);
//        if(1==1) {
//        	throw new RuntimeException("事务测试");
//        }
	}
	
	@GlobalTransactional
	public void update2() {
		UserOrder userOrder = new UserOrder();
		userOrder.setId(1L);
		userOrder.setOrderNumber("修改过后"+System.currentTimeMillis());
        int i = userOrderMapper.updateById(userOrder);
        System.out.println(i);
        feignServer.test1();
	}
}
