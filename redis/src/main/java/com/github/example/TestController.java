package com.github.example;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.example.bean.UserVo;
import com.github.example.config.RedisTemplateUtil;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;
    
    @Autowired
    private RedisTemplate redisTemplate;
	
	@GetMapping(value = "/test1")
    public String list() {
		try {
			//redisTemplateUtil.get("1");
			redisTemplate.opsForValue().set("zztest", "zz", 10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//UserVo userVo = (UserVo) redisTemplateUtil.get("1");
		return "test1";
    }
}
