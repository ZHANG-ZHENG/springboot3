package com.zz.test.user.bean;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class UserQuery {

	@Schema
	private Long orgId;
	
	private String name;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
