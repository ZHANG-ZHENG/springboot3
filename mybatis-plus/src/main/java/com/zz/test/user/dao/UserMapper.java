package com.zz.test.user.dao;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.test.user.entity.User;
import com.zz.test.user.model.UserVo;

public interface UserMapper extends BaseMapper<User>{
	
	@Select("select name from user where id=#{id}")
	UserVo selectUserVo(Long id);	

}
