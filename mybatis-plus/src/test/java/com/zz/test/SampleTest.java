package com.zz.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zz.test.user.bean.User;
import com.zz.test.user.dao.UserMapper;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    //@Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        //查询全部用户，参数是一个Wrapper，条件构造器，先不使用为null
        List<User> userList = userMapper.selectList(null);
        System.out.println("userList total:"+userList.size());
        userList.forEach(System.out::println);
    }
    
    //@Test
    public void testInsert() {
        User user = new User();
        user.setName("小7");
        user.setAge(21);
        user.setEmail("2312103645@qq.com");
        int insert = userMapper.insert(user);//如果没有设置id，那么会自动生成id
        System.out.println("insert:"+insert);//受影响行数
        System.out.println(user);//id会自动回填
    }
    
    //@Test
    public void testUpdate(){
        User user = new User();
        //可以通过条件自动拼接动态SQL
        user.setId(5L);
        user.setName("5,修改过后"+System.currentTimeMillis());
        //updateById 参数是一个对象！
        int i = userMapper.updateById(user);
        System.out.println(i);
    }  
    
    @Test
    public void testUpdateVersion(){
    	User user1 = userMapper.selectById(5L);
    	user1.setName("线程1,修改过后"+System.currentTimeMillis());
    	
    	User user2 = userMapper.selectById(5L);
    	user2.setName("线程2,修改过后"+System.currentTimeMillis());
    	
        int u2Result = userMapper.updateById(user2);
        int u1Result = userMapper.updateById(user1);
        
        System.out.println("u1Result="+u1Result);
        System.out.println("u2Result="+u2Result);
    }
}
