package com.zz.test.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.test.user.bean.UserQuery;
import com.zz.test.user.model.UserVo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/test")
@Tag(name = "业务模块1", description = "业务模块1说明")
public class TestController {
	
	@GetMapping(value = "/test1")
	@Operation(summary = "接口1", description = "接口1说明")
    public String test1() {
		return "test1";
    }

	/**
	 * 单一参数接口
	 */
	@PostMapping(value = "/test2")
	@Operation(summary = "单一参数接口2", description = "单一参数接口说明")
	@ApiResponse(description = "返回更新的用户")
    public String test2(@RequestBody @Parameter(description = "姓名") String name) {
		return "test2:"+name;
    }
	/**
	 * 对象参数接口
	 */	
	@PostMapping(value = "/test3")
	@Operation(summary = "接口3", description = "接口3说明")
    public UserVo test3(@RequestBody UserQuery userQuery) {
		UserVo userVo = new UserVo();
		userVo.setName("test3:"+userQuery.getName());
		return userVo;
    }
	
}
