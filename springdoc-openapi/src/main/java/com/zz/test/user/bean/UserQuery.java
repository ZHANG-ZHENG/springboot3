package com.zz.test.user.bean;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title="用户查询对象",description="用户查询对象说明")
public class UserQuery {

	@Schema(title="用户组织",description="用户组织参数说明")
	private Long orgId;
	@Schema(title="用户姓名",description="用户姓名参数说明")
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
