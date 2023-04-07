package com.zz.test.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class UserOrder {

	@TableId(type = IdType.ASSIGN_ID)//自3.3.0开始,默认使用雪花算法
    private Long id;
    private String orderNumber;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}
