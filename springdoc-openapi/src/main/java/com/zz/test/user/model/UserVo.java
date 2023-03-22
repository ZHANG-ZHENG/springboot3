package com.zz.test.user.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title="用户对象",description="用户对象说明")
public class UserVo {
	
	@Schema(title="用户姓名",description="用户姓名参数说明")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
