package com.github.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.example.bean.UserVo;
import com.github.example.config.RedisTemplateUtil;


@SpringBootTest
public class SampleTest {

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;
    
    @Test
    public void testVoSelect() {
//    	String userId = "1";
//    	UserVo userVo = (UserVo) redisTemplateUtil.get(userId);
//        if(userVo == null ){
//        	userVo = new UserVo();
//        	userVo.setId(Long.parseLong(userId));
//        	userVo.setName("jack"+userId);
//            redisTemplateUtil.set(userId,userVo);
//        }
    }
}
