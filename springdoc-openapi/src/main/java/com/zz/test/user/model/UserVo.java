package com.zz.test.user.model;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@ApiResponse(description = "用户对象")
public class UserVo {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
