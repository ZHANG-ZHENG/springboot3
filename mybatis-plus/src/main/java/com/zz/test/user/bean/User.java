package com.zz.test.user.bean;

import javax.xml.crypto.Data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;

public class User {
	
	@TableId(type = IdType.ASSIGN_ID)//自3.3.0开始,默认使用雪花算法
    private Long id;
    private String name;
    private Integer age;
    private String email;
	private Data createTime;
	private Data updateTime;
	@Version//乐观锁version注解
	private Integer version;

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Data getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}
	public Data getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Data updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
   
}